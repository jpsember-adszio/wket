require 'js_base'


task :default => [:build,:deploy]

desc "Builds project"
task :build do
  scall('mvn install -DskipTests=true')
end


desc "Deploy project to jetty; press ctrl-c to interrupt"
task :deploy do

  # Stop previous jetty process, if there is one
  kill_existing

  # Start jetty in background
  job1 = fork do
    exec "mvn jetty:run"
  end
  Process.detach(job1)
end

# Make a system call; raise SystemCallException if an error occurs
# Return output of command
#
# If verbose is set (the default), echos the output as it is being generated
#
def sy(cmd, verbose=true)
  require 'open3'

  stdin, stdout, stderr, wait_thr = Open3.popen3(cmd)

  # stdin, stdout and stderr should be closed explicitly in this form.
  stdin.close

  std_output = ''
  stdout.each do |line|
    std_output << line
    puts line.chomp if verbose
  end
  stdout.close

  err_output = ''
  stderr.each do |line|
    err_output << line
  end
  stderr.close

  unless wait_thr.value.success?
    msg = "Failed system call:\n"
    msg << cmd << "\n"
    unless std_output.empty?
      msg << "\nStd output:\n"
      msg << std_output
    end
    unless err_output.empty?
      msg << "\nError output:\n"
      msg << err_output
    end
    msg << "\n"
    raise SystemCallException,msg
  end
  std_output
end

def kill_existing
  output,success = scall('ps  aux | grep [j]etty',false)
  return if !success
  lines = output.split("\n")
  die "unexpected output:\n#{output}" if lines.length > 1
  return if lines.empty?
  pid = lines[0].split()[1]
  scall("kill #{pid}")
end
