public class ALU {
public static int result;
public static longword doOp(bit[] operation, longword a, longword b){

    //Subtracting the two longwords
        if(operation[0].getValue() == 1){
                if(operation[1].getValue() == 0){
                    if(operation[2].getValue() == 1){
                        if(operation[3].getValue() == 1){
                            return rippleAdder.subtract(a, b);
                        }
                    }
                }
            }

        //Adding two longworrds
        if(operation[0].getValue() == 0){
                if(operation[1].getValue() == 1){
                        if(operation[2].getValue() == 0){
                                if(operation[3].getValue() == 1){
                                        return rippleAdder.add(a,b);
                                }
                        }
                }
        }

        //Calling the AND method from Ripple Adder
        if(operation[0].getValue() == 1){
            if(operation[1].getValue() == 0){
                    if(operation[2].getValue() == 0){
                            if(operation[3].getValue() == 1){
                                    return a.and(b);
                            }
                    }
            }
    }

    //Calling the OR method from Ripple Adder
    if(operation[0].getValue() == 0){
        if(operation[1].getValue() == 0){
                if(operation[2].getValue() == 0){
                        if(operation[3].getValue() == 1){
                                return a.or(b);
                        }
                }
        }
}

//Calling the XOR method from RippleAdder
if(operation[0].getValue() == 1){
    if(operation[1].getValue() == 0){
            if(operation[2].getValue() == 0){
                    if(operation[3].getValue() == 0){
                            return a.xor(b);
                    }
            }
    }
}

//Calling the NOT method from RippleAdder
if(operation[0].getValue() == 0){
    if(operation[1].getValue() == 1){
            if(operation[2].getValue() == 0){
                    if(operation[3].getValue() == 0){
                            return a.not();
                    }
            }
    }
}
        

        //Bit shifting to the left
        for (int i = 0; i < result; i++) {
            bit newBit = new bit();
            for (int j = 0; j < 31; j++) {
                newBit.set(a.getBit(j + 1).getValue());
                a.setBit(j, newBit);
            }
            newBit.clear();
            a.setBit(31, newBit);
        }


        //Bit shifting to the right
        for(int i = 0; i < result; i++){
            bit newBits = new bit();
            for(int k = 0; k < 31; k--){
                newBits.set(b.getBit(k - 1).getValue());
                b.setBit(k, newBits);
            }
            newBits.clear();
           b.setBit(31, newBits);
        }
        return b;
    }
}

