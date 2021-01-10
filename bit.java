
public class bit implements IBit { //Declares and implement bits
    int bit = 0;
 

    public void set(int bit) { // sets the bit
       this.bit = bit;
    }

    public void toggle(){//switching the bit between 0 and 1
        if(bit == 0){
            bit = 1;
        }else{
            bit = 0;
        }
    }

    public int setValue(int bitVal) { //setting the value to a bit to 1
        return bitVal;
    }

    public void clear(int bitVal) { //clears the bit to 0
    }

    public int getValue() { //returns the result of the bit
        return bit;
    }
    

    public bit and(bit other) {// AND operation Operator
        if(bit == 0){
            if (bit == 1){
            }
        }
        return this;
        
    }
 

    public bit or(bit other) { // OR operation Operator
        if (bit == 0) {
           return this;
       }
       if(bit == 1){
           return this;
       }
       return this;
    }


    public bit xor(bit other) { // XOR operation Operator
       if(bit == 0){
           if(bit != 1){
               return this;
           } else {
               if(bit == 1){
                   if(bit !=0){
                       return this;
                   }
               }
           }
       }
       return this;
    }


    public bit not() { // NOT method Operator
        if(bit != 0){
            return this;
        }
        if(bit != 1){
            return this;
        }
        return this;
    }


    public String bittoString() { // returns either "0" or "1"
        switch(bit){
            case 1: return "1";
            case 0: return "0";
            
        }
        return null;
    }

    
   
    public void set() {
        this.bit = 1;

    }


    public void clear() {
        this.bit = 0;
    }

	public int getBit() {
		return this.bit;
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }


}

   