public class Assembler{
    public static String[] assemble(String[] string){
        String[] newArray = new String[string.length];
        for(int i = 0; i <= string.length - 1; i++){ //Looping the strings length
            newArray[i] = convert(string[i]);
        }
        return newArray;
    }

    //Converting the string and splitting it
    private static String convert(String var){ 
        String word = "";
        String[] newArray = var.split(" ");
    

   //Lexer method without state machine
    if(newArray[0].equals("move")){
        word = word + "0001 ";
        word = word + registers(newArray[1]);
        word = word + convertnumbers(newArray[2]);
        return word;
    }
    else if(newArray[0].equals("and")){
        word = word + "0000 ";
        word = word + registers(newArray[1]);
        word = word + " " + registers(newArray[2]);
        word = word + " " + registers(newArray[3]);
        return word;

    }
    else if(newArray[0].equals("or")){
        word = word + "0100 ";
        word = word + registers(newArray[1]);
        word = word + " " + registers(newArray[2]);
        word = word + " " + registers(newArray[3]);
        return word;

    }
    else if(newArray[0].equals("xor")){
        word = word + "0101 ";
        word = word + registers(newArray[1]);
        word = word + " " + registers(newArray[2]);
        word = word + " " + registers(newArray[3]);
        return word;

    }
    else if(newArray[0].equals("not")){
        word = word + "1000 ";
        word = word + registers(newArray[1]);
        word = word + " " + registers(newArray[2]);
        word = word + " " + registers(newArray[3]);
        return word;

    }
    else if(newArray[0].equals("leftshift")){
        word = word + "1001 ";
        word = word + registers(newArray[1]);
        word = word + " " + registers(newArray[2]);
        word = word + " " + registers(newArray[3]);
        return word;

    }
    else if(newArray[0].equals("rightshift")){
        word = word + "1100 ";
        word = word + registers(newArray[1]);
        word = word + " " + registers(newArray[2]);
        word = word + " " + registers(newArray[3]);
        return word;

    }
    else if(newArray[0].equals("FirstInterrupt")){ //Interrupts
        return "0010 0000 0000 0000";

    }
    else if(newArray[0].equals("SecondInterrupt")){
        return "0010 0000 0000 0001"; 
        
    }
    else if(newArray[0].equals("halt")){
        return "0000 0000 0001 0011";

    }
    //Jump, compare and branch comparing all here
   else if(newArray[0].equals("jump")){
        word = word + "0011 ";
        word = word + jumpconvert(newArray[1]);
        return word;
    }
    else if(newArray[0].equals("compare")){
        word = word + "0100 0000 ";
        word = word + registers(newArray[1]);
        word = word + " " + registers(newArray[2]);
        return word;

    }
    else if(newArray[0].equals("BranchIfEqual")){
        word = word + "0101 01 ";
        word = word + bitaddress(newArray[1]);
        return word;

    }

    else if(newArray[0].equals("BranchIfGreaterThanEqual")){
        word = word + "0101 11 ";
        word = word + bitaddress(newArray[1]);
        return word;

    }
    else if(newArray[0].equals("BranchIfGreaterThan")){
        word = word + "0101 10 ";
        word = word + bitaddress(newArray[1]);
        return word;

    }
    else if(newArray[0].equals("BranchIfLessThan")){
        word = word + "0101 00 ";
        word = word + bitaddress(newArray[1]);
        return word;

    }
    else if(newArray[0].equals("Push")){
        word = "0110 0000 0000 ";
        word = word + registers(newArray[1]);
    }

    else if(newArray[0].equals("Pop")){
        word = "0110 0100 0000 ";
        word = word + registers(newArray[1]);
    }

    else if(newArray[0].equals("Call")){
        word = "0101 10";
        word = word + registers(newArray[1]);
    }

    else if(newArray[0].equals("Return")){
        word = "0110 1100 0000 0000";
    }
    return word;
}

//Parsing
public static String registers(String reg){
    if(reg.equals("r1")){
        return "0001";
    }
    else if(reg.equals("r2")){
        return "0001";
    }
    else if(reg.equals("r3")){
        return "0100";
    }
    else if(reg.equals("r4")){
        return "0101";
    }
    else if(reg.equals("r5")){
        return "1000";
    }
    else if(reg.equals("r6")){
        return "1001";
    }
    else if(reg.equals("r7")){
        return "1100";
    }
    else if(reg.equals("r8")){
        return "0111";
    }
    else if(reg.equals("r9")){
        return "1111";
    }
    else if(reg.equals("r10")){
        return "1110";
    }
    else if(reg.equals("r11")){
        return "1011";
    }
    else if(reg.equals("r12")){
        return "0010";
    }
    else if(reg.equals("r13")){
        return "0100";
    }
    else if(reg.equals("r14")){
        return "0110";
    }
    else if(reg.equals("r15")){
        return "0100";
    }
    else if(reg.equals("r16")){
        return "1000";
    }
    return "test";
   
}

//Converts strings 
    private static String convertnumbers(String string) { 
        int integer = Integer.parseInt(string);
        String numtobin = Integer.toBinaryString(integer);

        int j = numtobin.length();
        while(j < 8){
            numtobin = "0" + numtobin;
            j++;
        }
        return numtobin = numtobin.substring(0,4) + " " + numtobin.substring(4, 8);
             
      }
      private static String bintodecimal(String number){
          int integer = Integer.parseInt(number);
          String numtobin = Integer.toBinaryString(integer);

          int j = numtobin.length();
          while(j < 8){
              numtobin = "0" + numtobin;
              j++;
          }
          return numtobin = numtobin.substring(0, 4) + " " + numtobin.substring(4, 8);
      }
      private static String jumpconvert(String number){
        int integer = Integer.parseInt(number);
        String numtobin = Integer.toBinaryString(integer);

        int j = numtobin.length();
        while(j < 12){
            numtobin = "0" + numtobin;
            j++;
        }
        return numtobin = numtobin.substring(0,4) + " " + numtobin.substring(4, 8) + " " + numtobin.substring(8, 12);
    }

    private static String bitaddress(String string) { 
        int num = Integer.parseInt(string);
        longword tap = new longword();

        tap.set(num);
        System.out.println(tap.toString());
        return tap.toString();
      }
    }
    


 
            

         

