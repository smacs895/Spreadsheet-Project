//Driver program for Workbook

public class WorkbookDriver extends Workbook{

  public static void main (String[] args){
    //create new workbook
    System.out.println("----------------New Workbook----------------");
    Workbook Workbook1 = new Workbook();
    Workbook1.display();
    System.out.println("\n");

    //add 12 sheets
    System.out.println("----------------Add 12 Sheets----------------");
    Workbook1.add();
    Workbook1.add();
    Workbook1.add();
    Workbook1.add();
    Workbook1.add();
    Workbook1.add();
    Workbook1.add();
    Workbook1.add();
    Workbook1.add();
    Workbook1.add();
    Workbook1.add();
    Workbook1.add();
    System.out.println(Workbook1.toString()); //Prints horizontally
    System.out.println("\n");

    // remove a sheet with name
    System.out.println("----------------Remove shEet7----------------");
    Workbook1.remove("shEet7");
    Workbook1.display();
    System.out.println("\n");
    //remove a sheet with index
    System.out.println("----------------Remove index 2----------------");
    Workbook1.remove(2);
    System.out.println(Workbook1.toString()); //Prints horizontally
    System.out.println("\n");

    //move a sheet integer
    System.out.println("----------------Move From position 7 to 0 before----------------");
    Workbook1.move(7,0,true);
    Workbook1.display();
    System.out.println("\n");
    //move a sheet name;
    System.out.println("----------------Move Sheet2 to after Sheet13----------------");
    Workbook1.move("ShEeT2", "Sheet13", false);
    System.out.println(Workbook1.toString()); //Prints horizontally
    System.out.println("\n");
    //moveToEnd
    System.out.println("----------------Move Index 4 to the end----------------");
    Workbook1.moveToEnd(4);
    Workbook1.display();
    System.out.println("\n");
    //moveToEnd
    System.out.println("----------------Move Sheet 10 to the end----------------");
    Workbook1.moveToEnd("SHeEt10");
    System.out.println(Workbook1.toString()); //Prints horizontally
    System.out.println("\n");


    //rename
    System.out.println("----------------Rename Sheet1 to dingin'----------------");
    Workbook1.rename("Sheet1", "Dingin'");
    System.out.println("\n");
    //rename
    System.out.println("----------------Rename Sheet1 to dingin----------------");
    Workbook1.rename("Sheet1", "Dingin");
    Workbook1.display();
    System.out.println("\n");
    //rename
    System.out.println("----------------Rename Sheet 11 to The Soul and Heart of IT----------------");
    Workbook1.rename("Sheet11","The Soul and Heart of IT");
    Workbook1.display();
    System.out.println("\n");
    //rename including special character
    System.out.println("----------------Rename Dingin to Sheet$%@£%^----------------");
    Workbook1.rename("Dingin", "Sheet$%@£%^");
    System.out.println("\n");

    System.out.println("----------------Return the sheetname Index 7----------------");
    //return sheet name
    System.out.println(Workbook1.sheetName(7));
    System.out.println("\n");

    //length
    System.out.println("----------------Current Length----------------");
    System.out.println(Workbook1.length());
    System.out.println("\n");

    System.out.println("----------------The end!----------------");
  }
}