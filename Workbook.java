public class Workbook {

  private String[] sheets;
  private int nextPosition;
  private int count;

  public Workbook() {
    sheets = new String[256];
    nextPosition = 0;
    count = 0;
    add();
    add();
    add();
  }

  public Workbook(int capacity) {
    sheets = new String[capacity];
    nextPosition = 0;
    count = 0;
  }

  public boolean addFirst(String sheet) {
    if (nextPosition < sheets.length) {
      for (int i = nextPosition; i >= 0; i--) {
        sheets[i + 1] = sheets[i];
      }
      sheets[0] = sheet;
      nextPosition++;
      count++;
      return true;
    } else {
      return false;
    }
  }

  public boolean addToEnd(String sheet) {
    if (nextPosition < sheets.length) {
      sheets[nextPosition] = sheet;
      count++;
      return true;
    } else {
      return false;
    }
  }

  public boolean add() {
    if (nextPosition < sheets.length) {
      sheets[nextPosition] = "Sheet" + (count + 1);
      nextPosition++;
      count++;
      return true;
    } else {
      System.out.println("Workbook is full cannot add any more sheets");
      return false;
    }
  }

  public void seeWholeArray() {
    int i;
    for (i = 0; i < sheets.length; i++) {
      System.out.println("Array position " + i + " has the value: " + sheets[i]);
    }
  }

  public void display() {
    int i;
    for (i = 0; i < nextPosition; i++) {
      System.out.println(sheets[i]);
    }
  }

  public int indexOf(String searchWord) {
    for (int i = 0; i < nextPosition; i++) {
      if (sheets[i].compareToIgnoreCase(searchWord) == 0) {
        return i;
      }
    }
    return -1;
  }

  public int remove(String sheetName) {
    if (sheets[1] == null) {
      System.out.println("Cannot delete last sheet (String one)");
      return -1;
    }

    int i = indexOf(sheetName);
    if (i == -1) {
      System.out.println("Cannot delete " + sheetName + " because it does not exist.");
      return -1;
    } else {
      sheets[i] = null;
      int j; // this is the shuffle to fill gaps
      for (j = i; j < sheets.length - 1; j++) {
        sheets[j] = sheets[j + 1];
      }
      nextPosition--;
      return i;
    }
  }

  public String remove(int indexPosition) {
    String nameOfSheet = sheets[indexPosition];
    if (sheets[1] == null) {
      // if second position is null and the shuffle is working
      //properly then there is only 1 sheet in the workbook.
      System.out.println("Cannot delete last sheet ( integer one)");
      return nameOfSheet + "Not Deleted";
    }
    sheets[indexPosition] = null;
    int j;
    for (j = indexPosition; j < sheets.length - 1; j++) {
      sheets[j] = sheets[j + 1];
    }
    nextPosition--;
    return nameOfSheet;
  }

  public int moveToEnd(String from) {
    int i = indexOf(from);
    String temp = from;
    if (i == -1) {
      System.out.println(from + " : No such sheet name");
    } else {
      int j; // this is the shuffle to fill gaps
      for (j = i; j < length() - 1; j++) {
        sheets[j] = sheets[j + 1];
      }
      sheets[length() - 1] = temp;
    }
    return i;
  }

  public String moveToEnd(int from) {
    int i = from;
    String temp = sheets[from];
    int j; // this is the shuffle to fill gaps
    for (j = i; j < length(); j++) {
      sheets[j] = sheets[j + 1];
    }
    sheets[length()] = temp;
    return sheets[i];
  }

  public int length() {
    int count = 0;
    for (int i = 0; sheets[i] != null; i++) {
      count++;
    }
    return count;
  }

  public int rename(String currentName, String newName) {
    int i = indexOf(newName);
    int j = indexOf(currentName);
    if (specialChars(newName) == true) {
      return -1;
    }
    if (i != -1) {
      System.out.println(newName + " : is already in List");
      return -1;
    } else if (j == -1) {
      System.out.println(currentName + " : not currently in the list");
      return -1;
    } else {
      sheets[j] = newName;
      return j;
    }
  }

  public int index(String SheetName) {
    int i = indexOf(SheetName);
    if (i == -1) {
      System.out.println("Sheet not Found");
      return -1;
    } else {
      return i;
    }
  }

  public String sheetName(int index) {
    if (0 <= index && index <= length()) {
      return sheets[index];
    } else
      return null;

  }

  public boolean specialChars(String s) {
    //String text = s.toUpperCase();
    //System.out.println(s);
    int i;
    String allowedChars = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    boolean specialChars = false;
    //System.out.println(specialChars);
    for (i = 0; i < s.length(); i++) {
      if (allowedChars.indexOf(s.charAt(i)) == -1) {
        specialChars = true;
        //System.out.println((allowedChars.indexOf(s.charAt(i))));
      }
    }

    if (specialChars) {
      System.out.println(
          s + " contains special characters please try again with letters and number only");
    } else {
      System.out.println(s + " is  an acceptable sheet name - sheet renamed.\n");
    }
    return specialChars;
  }

  public String move(int from, int to, boolean before) {
    String temp = sheets[from];
    if (from == to) {
      System.out.println("Sheets cannot be moved as same values were entered");
      return null;
    } else if (from < to) {
      int i;
      for (i = from; i < to; i++) {
        sheets[i] = sheets[i + 1];
      }
      if (before == true) {
        sheets[to - 1] = temp;
      } else {
        sheets[to] = temp;
      }
    } else {
      int j;
      for (j = from; j > to; j--) {
        sheets[j] = sheets[j - 1];
      }
      if (before == true) {
        sheets[to] = temp;
      } else {
        sheets[to + 1] = temp;
      }
    }
    return temp;
  }

  public int move(String from, String to, boolean before) {
    int indexOfFrom = indexOf(from);
    int indexOfTo = indexOf(to);

    String temp = from;
    if (indexOfFrom == indexOfTo) {
      System.out.println("Sheets cannot be moved as same values were entered");
      return 0;
    } else if (indexOfFrom < indexOfTo) {
      int i;
      for (i = indexOfFrom; i < indexOfTo; i++) {
        sheets[i] = sheets[i + 1];
      }
      if (before == true) {
        sheets[indexOfTo - 1] = temp;
      } else {
        sheets[indexOfTo] = temp;
      }
    } else {
      int j;
      for (j = indexOfFrom; j > indexOfTo; j--) {
        sheets[j] = sheets[j - 1];
      }
      if (before == true) {
        sheets[indexOfTo] = temp;
      } else {
        sheets[indexOfTo + 1] = temp;
      }
    }
    return indexOfFrom;
  }

  public String toString() {
    int i;
    String outputString = "[";
    for (i = 0; i < length(); i++) {
      outputString = outputString + sheets[i] + ",";
    }
    outputString = outputString.substring(0, outputString.length() - 1);
    outputString = outputString + "]";
    return outputString;
  }
}