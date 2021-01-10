public class CPU_test2{
        void runsTest(){
        String[] test1 = new String[] {"jump 5", "halt"};
        String[] assembledCode = Assembler.assemble(test1); //Assembles the code
        Computer CPU1 = new Computer(); //Declaring Computer
        CPU1.preload(assembledCode); //Preloads
        CPU1.run();
    }
}