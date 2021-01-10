public class ALU_Tester extends ALU{

    public static void runsTest(){ 
        try {
        longword ALU0 = new longword();
        longword ALU1 = new longword();
        longword ALU2 = new longword();
        longword ALU3 = new longword();

        ALU0.set(0);
        ALU1.set(-5);
        ALU2.set(5);
        ALU3.set(20);

        //Bit subtract
        bit[] bitsub = new bit[4];

        bitsub[0].set(1);
        bitsub[1].set(0);
        bitsub[2].set(1);
        bitsub[3].set(1);

        System.out.println("Expected: ");
        System.out.println("Actual: " + ALU.doOp(bitsub, ALU0, ALU1).toString());
        System.out.println("Actual: " + ALU.doOp(bitsub, ALU2, ALU3).toString());
        System.out.println("Actual: " + ALU.doOp(bitsub, ALU0, ALU3).toString());
        System.out.println("Acutal: "+ ALU.doOp(bitsub, ALU3, ALU2).toString());


        //Bit Add
        bit[] bitadd = new bit[4];

        bitadd[0].set(0);
        bitadd[1].set(1);
        bitadd[2].set(0);
        bitadd[3].set(1);

        System.out.println("Expected: ");
        System.out.println("Actual: " + ALU.doOp(bitadd, ALU0, ALU1).toString());
        System.out.println("Actual: " + ALU.doOp(bitadd, ALU2, ALU3).toString());
        System.out.println("Actual: " + ALU.doOp(bitadd, ALU0, ALU3).toString());
        System.out.println("Acutal: "+ ALU.doOp(bitadd, ALU3, ALU2).toString());


        //Bit AND method
        bit[] bitAnd = new bit[4];

        bitAnd[0].set(1);
        bitAnd[1].set(0);
        bitAnd[2].set(0);
        bitAnd[3].set(1);

        System.out.println("Expected: ");
        System.out.println("Actual: " + ALU.doOp(bitAnd, ALU0, ALU1).toString());
        System.out.println("Actual: " + ALU.doOp(bitAnd, ALU2, ALU3).toString());
        System.out.println("Actual: " + ALU.doOp(bitAnd, ALU0, ALU3).toString());
        System.out.println("Acutal: "+ ALU.doOp(bitAnd, ALU3, ALU2).toString());


        //Bit OR method
        bit[] bitOr = new bit[4];

        bitOr[0].set(0);
        bitOr[1].set(0);
        bitOr[2].set(0);
        bitOr[3].set(1);

        System.out.println("Expected: ");
        System.out.println("Actual: " + ALU.doOp(bitOr, ALU0, ALU1).toString());
        System.out.println("Actual: " + ALU.doOp(bitOr, ALU2, ALU3).toString());
        System.out.println("Actual: " + ALU.doOp(bitOr, ALU0, ALU3).toString());
        System.out.println("Acutal: "+ ALU.doOp(bitOr, ALU3, ALU2).toString());




        //Bit XOR method
        bit[] bitXor = new bit[4];

        bitXor[0].set(1);
        bitXor[1].set(0);
        bitXor[2].set(0);
        bitXor[3].set(0);

        System.out.println("Expected: ");
        System.out.println("Actual: " + ALU.doOp(bitXor, ALU0, ALU1).toString());
        System.out.println("Actual: " + ALU.doOp(bitXor, ALU2, ALU3).toString());
        System.out.println("Actual: " + ALU.doOp(bitXor, ALU0, ALU3).toString());
        System.out.println("Acutal: "+ ALU.doOp(bitXor, ALU3, ALU2).toString());


        
        //Bit NOT method
        bit[] bitNot = new bit[4];

        bitNot[0].set(0);
        bitNot[1].set(1);
        bitNot[2].set(0);
        bitNot[3].set(0);

        System.out.println("Expected: ");
        System.out.println("Actual: " + ALU.doOp(bitNot, ALU0, ALU1).toString());
        System.out.println("Actual: " + ALU.doOp(bitNot, ALU2, ALU3).toString());
        System.out.println("Actual: " + ALU.doOp(bitNot, ALU0, ALU3).toString());
        System.out.println("Acutal: "+ ALU.doOp(bitNot, ALU3, ALU2).toString());



        //Bit Leftshift
        bit[] bitleftshift = new bit[4];

        bitleftshift[0].set(1);
        bitleftshift[1].set(1);
        bitleftshift[2].set(1);
        bitleftshift[3].set(0);

        System.out.println("Expected: ");
        System.out.println("Actual: " + ALU.doOp(bitleftshift, ALU0, ALU1).toString());
        System.out.println("Actual: " + ALU.doOp(bitleftshift, ALU2, ALU3).toString());
        System.out.println("Actual: " + ALU.doOp(bitleftshift, ALU0, ALU3).toString());
        System.out.println("Acutal: "+ ALU.doOp(bitleftshift, ALU3, ALU2).toString());


        
        //Bit Rightshift
        bit[] bitrightshift = new bit[4];
        
        bitrightshift[0].set(1);
        bitrightshift[1].set(0);
        bitrightshift[2].set(1);
        bitrightshift[3].set(0);

        System.out.println("Expected: ");
        System.out.println("Actual: " + ALU.doOp(bitrightshift, ALU0, ALU1).toString());
        System.out.println("Actual: " + ALU.doOp(bitrightshift, ALU2, ALU3).toString());
        System.out.println("Actual: " + ALU.doOp(bitrightshift, ALU0, ALU3).toString());
        System.out.println("Acutal: "+ ALU.doOp(bitrightshift, ALU3, ALU2).toString());

            
        } catch (Exception e) {
            System.out.println("Hello");
        }
        

    }
    
}
