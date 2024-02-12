import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.NoSuchElementException;
public class AttendanceTaker {
    private File inputFile;
    private static File outputFile;
    public AttendanceTaker(File inputFile, File outputFile){
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }
    public AttendanceTaker(String fileIn, String fileOut){
        this(new File(fileIn), new File(fileOut));
    }
    Scanner s = null;
    String record = null;
    static PrintWriter print = null;
    public void takeAttendance() throws FileNotFoundException, BadFileException {
        try{
            Scanner scan = new Scanner(inputFile);
            if (scan.hasNextLine()){
                record = scan.nextLine();
            } else {
                throw new BadFileException("The input file was empty");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException n) {
            throw new BadFileException();
        } catch (BadFileException b) {
            System.out.println(b.getMessage());
        }
        boolean valid = false;
            if (record.startsWith("|--") && record.endsWith("--|") && record.length() >= 6){
                valid = true;
            } else {
                throw new BadFileException("The file doesn't have correct beginning or end");
            }
        s.close();
        String r2 = record.replace("|--", "");
        String r3 = r2.replace("--|", "");
        String [] record2 = r3.split("---");
        for (String n : record2) {
            try{
                processStudentAttendance(n, s, print);
            } catch (InvalidNameFormatException f){
                System.out.printf("\nSkipping %s because of an invalid name format: %s", n, f.getMessage());
            } catch (InvalidAttendanceInformationException a){
                System.out.printf("\nSkipping %s because of an invalid attendance information: %s", n, a.getMessage());
            } finally {
                s.close();
                print.close();
            }
        }
    }
    private static void processStudentAttendance(String name, Scanner consoleScanner, PrintWriter printWriter)
        throws InvalidNameFormatException, InvalidAttendanceInformationException {
            try {
                print = new PrintWriter(outputFile);
            } catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            }
            if (!(name.equals(name.toUpperCase()))) {
                print.println("-");
                throw new InvalidNameFormatException("The name isn't uppercase only");
            } else {
                char [] chars = name.toCharArray();
                for (char d : chars){
                    if (Character.isDigit(d)){
                        try {
                            print.println("-");
                            throw new InvalidNameFormatException();
                        } catch (InvalidNameFormatException a){
                            throw new InvalidNameFormatException("The name has a digit");
                        } finally {
                        System.out.println(name + ": to console and await for user input.");
                        }
                    } else if (d == '|'){
                        print.println("-");
                        throw new InvalidNameFormatException("The name has a pipe character");
                    }
                }
            }
            System.out.println(name + ": to console and await for user input.");
            if (consoleScanner.nextLine().equals("")) {
                print.println("-");
                throw new InvalidAttendanceInformationException("Attendance information missing");
            } else if ((!(consoleScanner.nextLine().equals("A"))) || (!(consoleScanner.nextLine().equals("P")))) {
                print.println("-");
                throw new InvalidNameFormatException("Attendance information is not P or A");
            } else {
                print.println(consoleScanner.nextLine());
            }
    }
    public static void main(String[] args) {
        AttendanceTaker one = new AttendanceTaker("Present.txt","Out.txt");
        AttendanceTaker two = new AttendanceTaker("Here.txt","Results.txt");

    }
}
