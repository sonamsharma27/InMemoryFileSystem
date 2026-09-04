//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    FileSystem fs = new FileSystem();
    System.out.println("******************");
    fs.mkdir("home");
    fs.cd("home");
    fs.mkdir("sonam");
    fs.cd("home_sonam");
    fs.ls("/");
    fs.ls();
    fs.ls("/home");
    fs.mkdir("insideHome");
    fs.touch("home_sample.txt");
    fs.touch("home_sample.txt");
    fs.ls("/");
    fs.ls();
    fs.mkdir("/home/sonam/nested");
    fs.cd("/home/sonam");
    fs.pwd();
    fs.cd("/home/insideHome");
    fs.pwd();
    fs.ls("/home/sonam/");
}
