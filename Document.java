import java.util.Scanner;

public class Document {
    private StringBuffer textBuffer;

    public Document() {
        this.textBuffer = new StringBuffer();
    }

    public Document (StringBuffer textBuffer){
        this.textBuffer = textBuffer;
    }
    
    public void addText(String input){
        textBuffer.append(input);
        System.out.println("[addText] Added: \"" + input + "\"");
    }

    public void clearText(){
        textBuffer.setLength(0);
        System.out.println("[clearText] Text cleared.");
    }

    public void reverseText(){
        textBuffer.reverse();
        System.out.println("[reverseText] Text reversed.");
    }

    public void deleteText(int start , int end){
        if(start < 0 || end > textBuffer.length() || start > end){
        System.out.println("[deletetext] Invalid range: (" + start + ", " + end + ")");
        return;
        }
        textBuffer.delete(start , end);
        System.out.println("[deleteText] Deleted characters from index " + start + " to " + end + ".");
    }

    public void displayText(){
        System.out.println("[displayText] Current Text: \"" + textBuffer.toString() + "\"");
    }
    public static void main (String [] args){

        Scanner scanner = new Scanner(System.in);
        Document doc = new Document();
        int choice;
        do {
            System.out.println("\n-------- MENU --------");
            System.out.println("1. Add Text");
            System.out.println("2. Reverse Text");
            System.out.println("3. Delete Text (by range)");
            System.out.println("4. Clear Text");
            System.out.println("5. Display Text");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
 
            choice = scanner.nextInt();
            scanner.nextLine(); 
 
            switch (choice) {
 
                case 1:
                    System.out.print("Enter text to add: ");
                    String input = scanner.nextLine();
                    doc.addText(input);
                    doc.displayText();
                    break;
 
                case 2:
                    doc.reverseText();
                    doc.displayText();
                    break;
 
                case 3:
                    System.out.print("Enter start index: ");
                    int start = scanner.nextInt();
                    System.out.print("Enter end index: ");
                    int end = scanner.nextInt();
                    scanner.nextLine();
                    doc.deleteText(start, end);
                    doc.displayText();
                    break;
 
                case 4:
                    doc.clearText();
                    doc.displayText();
                    break;
 
                case 5:
                    doc.displayText();
                    break;
 
                case 0:
                    System.out.println("Exiting...");
                    break;
 
                default:
                    System.out.println("Invalid choice!");
            }
 
        } while (choice != 0);
 
        scanner.close();
    }
}
