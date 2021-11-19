package cli;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.stream.Stream;


public class Terminal {
    public class Parser {
    String commandName;    
    String[] args; 
    public boolean parse(String input){
        String[] cmd =input.split(" ");
        this.args= new String[cmd.length-1];
        this.commandName = cmd[0];
        for(int i = 1 ; i<cmd.length;i++){
            this.args[i-1]=cmd[i];
            
        }
        if(this.commandName.equals("cd")&&(this.args.length==0||this.args.length==1)){
            return true;
        }
        else if(this.commandName.equals("pwd")&&this.args.length==0){
            return true;
        }
        else if(this.commandName.equals("rm")&& this.args.length==1){
            return true;
        }
        else if(this.commandName.equals("exit")){
            return true;
        }
        else if(this.commandName.equals("ls")&&(this.args.length==0||this.args.length==1)){
            return true;
        }
        else if(this.commandName.equals("touch")&& this.args.length==1){
            return true;
        }
        else if(this.commandName.equals("cp")&& this.args.length==2){
            return true;
        }
        else if(this.commandName.equals("cp")&& this.args.length==3){
            return true;
        }
        else if (this.commandName.equals("echo")&&(this.args.length>=1)){
            return true;
        }
        else if (this.commandName.equals("mkdir")&&(this.args.length>=1)){
            return true;
        }
        else if (this.commandName.equals("rmdir")&&(this.args.length==1)){
            return true;
        }
        else if (this.commandName.equals("cat")&&(this.args.length==1||this.args.length==2)){
            return true;
        }
        else{
            return false;
        }
    };
 
    public String getCommandName(){
        
        return this.commandName;
        
    } ;
 
    public String[] getArgs(){
        
        return this.args;
        
    } ;
}


    Parser parser;
    String home;

    public Terminal() {
        this.home = System.getProperty("user.dir");
        this.parser = new Parser();
    }
    
    public void pwd(){
        System.out.println(home);
    }
    
    public void ls(String[] args) {
       if(args.length == 0){
            String[] files;
            File f = new File(home);
            files = f.list();
            String file;
            for (int i = 0 ; i < files.length ; i++) {
                file = files[i];
                System.out.println(file);
            }
       }
       else if(args[0].equals("-r")){
            String[] files;
            File f = new File(home);
            files = f.list();
            String file;
            for (int i = files.length-1 ; i >= 0  ; i--) {
                file = files[i];
                System.out.println(file);
            }
       }
       else{System.out.println("Error! Invalid command ");}
    };
    
   
    public void cd(String[] args) {
      
      if(args.length == 0 ){
          this.home = System.getProperty("user.home");
      }
      else if(args[0].equals("..")){
            String[] newHome = home.split("\\\\");
            home = "";
            for(int i = 0; i< newHome.length-1; i++){
                if(i ==newHome.length-2 ){
                    home +=newHome[i];
                }
                else{home +=newHome[i]+"\\";}                

            }
      }
      else{
          Path p =  Path.of(args[0]);
          if(p.isAbsolute()){
              File f = p.toFile();
              if(f.exists()){home = p.toString();}
              else{System.out.println("Error! Invalid path ");}
          }
          else{
              File f = new File(home+"\\"+p.toString());
                if(f.exists()){
                    home = home+"\\"+p.toString();
                }
                else{
                    System.out.println("Error! Invalid path! ");
                }
            }
      }
    };
    
    public void rm(String[] args) {
        Path p =  Path.of(args[0]);
        File f = new File(home+"\\"+p.toString());
        if(f.exists()){
            f.delete();
        }
        else{System.out.println("file does not exists");}
        
    };
    
    public void touch(String[] args) throws IOException{
            Path p=Path.of(args[0]);
            if (p.isAbsolute()){
                File f = new File(args[0]);
                f.createNewFile();
            }
            else{
                File f = new File(home+"\\"+args[0]);
                f.createNewFile();
            }
        
    };
    
    public void cp(String[] args) throws FileNotFoundException, IOException{
        FileReader f1 = new FileReader(args[0]);
        FileWriter f2 = new FileWriter(args[1]);
        int i;  
        while ((i = f1.read()) != -1) {  
            f2.write(i);  
        }
        f1.close();
        f2.close();
        
    };
    
    
    public void cp_r(String[] args)  throws IOException {
        File s = new File(home+"\\"+args[1]);
        File d = new File(home+"\\"+args[2]);
        Path sp = Path.of(home+"\\"+args[1]);
        Path dp = Path.of(home+"\\"+args[2]);
        String[] ds ;
        try (Stream<Path> stream = Files.walk(sp)) {
            stream.forEach(source -> copy(source, dp.resolve(sp.relativize(source))));
        }
    };
    private void copy(Path source, Path dest) {
        try {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
   
    
    public void echo(String[] args){
        for (String word : args){
            System.out.print(word + " ");
        }
        System.out.println();
    }
    public void mkdir(String[] args){
        for (String word : args){
            if (Path.of(word).isAbsolute()){
                File file = new File(word);
                boolean isCreated = file.mkdir();
            }
            else{
                File file = new File(home + "\\" + word);
                boolean isCreated = file.mkdir();
            }
        }
    }
    public void rmdir(String [] args) {
        if (args[0].equals("*")){
            Path path = Path.of(home);
            File file = path.toFile();
            File [] files = file.listFiles();
            for (File file1 : files){
                if (file1.length()==0 && file1.isDirectory())
                    file1.delete();
            }
        }
        else{
            if (Path.of(args[0]).isAbsolute()){
                Path p = Path.of(args[0]);
                File file = p.toFile();
                if(file.exists()&&file.isDirectory()){
                    boolean isDeleted = file.delete();
                    if (!isDeleted){
                        System.out.println("directory is not empty!");
                    }
                }
                else{System.out.println("directory not found");}
                
            }
            else{
                Path p = Path.of(home+"\\"+args[0]);
                File file = p.toFile();
                if(file.exists()&&file.isDirectory()){
                    boolean isDeleted = file.delete();
                    if (!isDeleted){
                        System.out.println("directory is not empty!");
                    }
                }
                else{System.out.println("directory not found");}
            }
        }

    }
    public void cat(String[] args){
        try {
            
            for (String word : args){
                Path path = Path.of(home+"//"+word);
                File file = path.toFile();
                Scanner read = new Scanner(file);
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    System.out.println(line);
                }
                read.close();
            }
        }catch (FileNotFoundException e){
             System.out.println("File not found");
        }
    }
    
    public void exit() {
        System.exit(0);
    };
 
    public void chooseCommandAction() throws IOException {
       if(parser.commandName.equals("cd")){
            cd(parser.args);
        }
       else if(parser.commandName.equals("pwd")){
            pwd();
        }
       else if(parser.commandName.equals("exit")){
            exit();
        }
       else if(parser.commandName.equals("rm")){
            rm(parser.args);
        }
       else if(parser.commandName.equals("ls")){
            ls(parser.args);
        }
       else if(parser.commandName.equals("touch")){
            touch(parser.args);
        }
       else if(parser.commandName.equals("cp") && parser.args.length == 2){
            cp(parser.args);
        }
       else if(parser.commandName.equals("cp") && parser.args.length == 3){
            cp_r(parser.args);
        }
       else if(parser.commandName.equals("echo")){
            echo(parser.args);
        }
        else if(parser.commandName.equals("mkdir")){
            mkdir(parser.args);
        }
        else if(parser.commandName.equals("rmdir")){
            rmdir(parser.args);
        }
        else if (parser.commandName.equals("cat")){
            cat(parser.args);
        }
        else{System.out.println("Error invalid command!");}
       

    }; 
 
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        
        Terminal t = new Terminal();
        while(true){
           String in = s.nextLine();
            if (t.parser.parse(in)) {
                t.chooseCommandAction();
            }
            else {
                System.out.println("Error invalid command!");
            }
        }
        
        
    }
}
