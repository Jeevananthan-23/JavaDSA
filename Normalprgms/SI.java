public class SI {

    public static void main(String[] args) {
        String a=null;
        Integer b=null;
        if(a==String.valueOf(b)){
            System.out.print("1");
        }
        else if(String.valueOf(b).equals(a)){
            System.out.print("2");
        } else if(String.valueOf(b).equalsIgnoreCase(a)){
            System.out.print("1");
        }
        else{
            System.out.println("4");
        }
       }

}

