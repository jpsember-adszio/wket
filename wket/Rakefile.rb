require 'js_base'

task :default => [:build,:deploy]

desc "Builds project"
task :build do
  scall('mvn install -DskipTests=true')
end

desc "Deploy project to jetty"
task :deploy do

  kill_existing_jetty

  # Start jetty in background
  job1 = fork do
    exec "mvn jetty:run"
  end
  Process.detach(job1)
end

def kill_existing_jetty
  output,success = scall('ps  aux | grep [j]etty',false)
  return if !success
  lines = output.split("\n")
  die "unexpected output:\n#{output}" if lines.length > 1
  return if lines.empty?
  pid = lines[0].split()[1]
  scall("kill #{pid}")
end
