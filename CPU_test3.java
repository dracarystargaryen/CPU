public class CPU_test3{
    void runsTest(){

    String[] test1 = new String[] {"move r2 5","Push r2", "Pop r8", "FirstInterrupt"};
    String[] assembledCode = Assembler.assemble(test1); //Assembles the code
    System.out.println(assembledCode[0]);
    System.out.println(assembledCode[1]);
    System.out.println(assembledCode[2]);
    System.out.println(assembledCode[3]);
    Computer CPU1 = new Computer(); //Declaring Computer
    CPU1.preload(assembledCode); //Preloads
    CPU1.run();
   }
}