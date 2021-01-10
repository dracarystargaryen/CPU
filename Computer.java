
public class Computer {
    //declaring longword as global variables
    private Memory MemoryPieces;
    private longword PC;
    private longword Op1;
    private longword Op2;
    private longword Opcode;
    private longword result;
    private longword currentInstruction;
    private longword shiftLongword;
    private longword[] registers;
    private longword storeIndex;
    private bit halt;
    private bit[] bitCompare = new bit[2];
    private int flag = 0;
    private longword stack;
    private bit[] adding = new bit[8];



//Initializing all declared global variables
    void computer(){
        this.halt = new bit();
        this.halt.set(1);
        this.PC = new longword();
        this.PC.set(0);
        this.MemoryPieces = new Memory();
        this.Op1 = new longword();
        this.Op2 = new longword();
        this.Opcode = new longword();
        this.result = new longword();
        this.currentInstruction = new longword();
        this.shiftLongword = new longword();
        this.registers = new longword[10];
    
    for(int i = 0; i < 8; i++){
        this.adding[i] = new bit();
    }

    adding[0].set(1); 
    adding[1].set(1);
    adding[2].set(1);
    adding[3].set(0);
    adding[4].set(0);
    adding[5].set(0);
    adding[6].set(0);
    adding[7].set(0);

}

    //Running the method
    void run(){
        PC.set(0);//Declaring each method used in PC
    
        while(halt.getValue() != 0){
            this.fetch();
            this.decode();
            this.execute();
            
        while(halt.getValue() != 1){
            this.store();
        }
    }
}
    //Fetch method
    private void fetch() {
        
        longword incrementBit = new longword();
        incrementBit.set(2);

        
        this.currentInstruction.set(0,this.MemoryPieces.read(this.PC).getUnsigned());
        this.PC.copy(0, rippleAdder.add(PC, currentInstruction));
        
    }


    //Fetch decode shift op1 and op2 together
    private void decode(){
        longword bitmask = new longword();
        bitmask.set(16);
        longword temps = new longword();
        temps.set(0);

        //Begins shifting bits to the right
        this.currentInstruction.copy(0, temps.rightShift(10));
        temps.copy(0, this.currentInstruction);

        this.Opcode.copy(0, temps.rightShift(10));
        if(this.Opcode.getSigned() == 0){
        

        //Method begins running through all the instructions to decode each bit
        } else if(this.Opcode.getSigned() == 1){
            longword shiftmask = new longword();
            shiftmask.set(225);
            temps.copy(0, temps.rightShift(16));
            temps.copy(0, currentInstruction);

            this.Op1.copy(0,temps.and(bitmask));
            temps.copy(0, currentInstruction);

            this.Op2.copy(0, temps.and(shiftmask));
            this.shiftLongword.copy(0, this.Op2);

            //Begins shifting 
            if(this.Op2.getBit(24).getValue() == 1){
                int j = 0;
                int bits = 0;
                while(bits != 1){
                    if(this.shiftLongword.getBit(j).getValue() == 0){
                        this.shiftLongword.getBit(j).set(1);
                        j++;
                    }else{
                        bits = 1;
                    }
                }
            }
        }
        if (this.Opcode.getSigned() == 3){
            longword Jump = new longword();
            Jump.set(409510);
            this.Op1.copy(0,currentInstruction.and(Jump));
        }
        //Jump process goes here
        else if((int) this.Opcode.getUnsigned() == 4){ //Stores the jump process
            int i = 0;
            bit[] Op = new bit[4];
            for(int j = 0; j < 4; j++){
                Op[j] = new bit();
            }
            Op[0].set(0);
            Op[1].set(0);
            Op[2].set(0);
            Op[3].set(0);

            temps.copy(0, temps.rightShift(4));
            //Begins decoding Op1
            this.Op1.copy(0, this.registers[((int) this.currentInstruction.rightShift(4).and(bitmask).getUnsigned()) - 1]);
            temps.copy(0, currentInstruction);

            //Decoding Op2
            temps.copy(0,temps.rightShift(8));
            this.Op2.copy(0,this.registers[((int)this.currentInstruction.rightShift(8).and(bitmask).getUnsigned()) - 1]);
            temps.copy(0,currentInstruction);

            i = ALU.doOp(Op, this.Op1, this.Op2).getSigned();

            if(i == 0){
                this.bitCompare[0].set(1);
                this.bitCompare[1].set(1);

            }
            if(i >= 0){
                this.bitCompare[0].set(1);
                this.bitCompare[1].set(1);
            
            }
            if(i <= 0){
                this.bitCompare[0].set(1);
                this.bitCompare[1].set(1);
            }
    

        }

        //Starts masking the bits to begin shifting
        else if((int) this.Opcode.getUnsigned() == 2){ 
         }
         else if((int) this.Opcode.getUnsigned() == 6){
            longword twoBits = new longword();
            longword pushPop = new longword();
            longword subFour = new longword();
            subFour.set(4);
            pushPop.set(15);
            twoBits.set(192);

            //Using Op1 for push and pop
            if(temps.getBit(20).getValue() == 0 && temps.getBit(21).getValue() == 0){ //Push method
                this.adding[3].set(1);
                this.Op1.copy(0,temps.and(pushPop));
                this.MemoryPieces.write(this.stack,this.registers[this.Op1.getSigned()]);
                this.stack.copy(0,ALU.doOp(adding, this.stack, subFour));
            }
            else if(temps.getBit(20).getValue() == 0 && temps.getBit(21).getValue() == 1){ //Pop method
                this.adding[3].set(0);
                this.Op1.copy(0,temps.and(pushPop));
                this.stack.copy(0,ALU.doOp(adding, this.stack, subFour));
                this.registers[this.Op1.getSigned()].copy(0, this.MemoryPieces.read(this.stack));

            }
            else if(temps.getBit(20).getValue() == 1 && temps.getBit(21).getValue() == 0){ //Call method
                this.adding[3].set(1);


                this.MemoryPieces.write(this.stack,this.MemoryPieces.read(ALU.doOp(adding,this.PC,subFour)));
                this.stack.copy(0,ALU.doOp(adding, this.stack, subFour));
                this.flag = 1;


            }
            else if(temps.getBit(20).getValue() == 1 && temps.getBit(21).getValue() == 1){ //Returns the opcode
                this.adding[3].set(0);
                this.stack.copy(0, ALU.doOp(adding, this.stack, subFour));
                this.PC.copy(0, this.MemoryPieces.read(this.stack));
            }
    }
               
         else{
                temps.copy(0, temps.rightShift(2));
                this.Op1.copy(0, this.registers[(int) temps.and(bitmask).getUnsigned()]);
                temps.copy(0, currentInstruction);
                
                this.storeIndex.copy(0, temps.and(bitmask));
            }
        }




    //Fetch execute and shift each code 5 times for 2 bits
    private void execute() {
        if(this.Opcode.getUnsigned() == 0){
            this.halt.set(0);
        } else if(this.Opcode.getUnsigned() == 2){ //Interrupts the computer
            longword Address = new longword();

            if(this.currentInstruction.getBit(32).getValue() == 0){
                for(int j = 0; j < registers.length; j++){
                    
                }
            } else{
                for(int x = 0; x < 8194; x+=2){
                    Address.set(x);
                
                }
            }
        } else { //Setting bits and calls the ALU method for Op1 and Op2
            bit[] instructions = new bit[6];
            for(int l = 0; l < 6; l++){
                instructions[l] = new bit(); //Branching the bits
                bit[] bitbranch = new bit[2];
                bitbranch[0] = new bit();
                bitbranch[1] = new bit();

                bitbranch[0] = this.currentInstruction.getBit(30);
                bitbranch[1] = this.currentInstruction.getBit(31);

                if(this.bitCompare[0].getValue() == bitbranch[0].getValue()){
                    if(this.bitCompare[1].getValue() == bitbranch[1].getValue()){
                        this.flag = 1;
                    }
                }
            }if(this.Opcode.getUnsigned() != 1){ //
                bit[] operand = new bit[4];
                for(int j = 0; j < 4; j++){
                    operand[j] = new bit();
                }
            }
    
		
        instructions[0].set(this.Opcode.getBit(32).getValue());
        instructions[1].set(this.Opcode.getBit(31).getValue());
        instructions[2].set(this.Opcode.getBit(29).getValue());
        instructions[3].set(this.Opcode.getBit(28).getValue());        
        this.result.copy(0, ALU.doOp(instructions, Op1, Op2));
        }

    }
    //Storing the values
    private void store(){
        if(this.Opcode.getUnsigned() == 1){
            this.registers[(int) this.Op1.getUnsigned()].set(this.shiftLongword.getSigned());

        }else if((int)this.Opcode.getUnsigned() == 2){
            this.registers[this.storeIndex.getSigned() - 1].copy(0,this.result);

        }else{
            this.registers[this.storeIndex.getSigned()].copy(0, this.result);
        }
       if(this.Opcode.getSigned() == 3){

       }
       //Branch
       
    }


    //Preload the bits to start initializing 
   public void preload(String[] Preload){
        String[] Preloader = new String[((Preload.length)/2) + 1];
        longword bitaddress = new longword();
        longword bits = new longword();
        longword currentbits = new longword();
        currentbits.set(2);
        String num = "0000 0000 0000 0000"; //Use a string to run through the bits
        bitaddress.set(0);
        bits.set(0);

        int loadedBit = 0;


        for(int j = 0; j < Preload.length - 1; j+= 2){
            Preloader[j] = Preloader[j] + " " + Preload[j + 1];
            j++;
        }
        if(Preload.length%2 != 0){
            Preloader[loadedBit] = Preload[Preload.length - 1] + num;
            
        }
        //Adding the bits to memory
        for(int j = 0; j <= Preloader.length - 1; j++){
            longword coLongword = new longword();
            coLongword.set(0);

        for(int x = 0; x < Preloader[j].length() - 1; x++){
            bit setbit = new bit();
            if(Preloader[j].charAt(x) == '0'){
                setbit.set(0);
                bitaddress.setBit(loadedBit, setbit);
                loadedBit++;

            }else if(Preloader[j].charAt(x) == '1'){
                setbit.set(1);
                bitaddress.setBit(currentbits, setbit);
                loadedBit++;
            }
        }

        loadedBit = 0;
        MemoryPieces.write(bitaddress, bits);
        bits.copy(0,rippleAdder.add(bits, currentbits));
    }
   }
}  
