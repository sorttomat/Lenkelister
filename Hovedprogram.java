class Hovedprogram {
    public static void main(String[] args) {
        Lenkeliste<Integer> lenkeliste = new Lenkeliste<Integer>();


        for(int i = 0; i < 10; i ++) {
            lenkeliste.leggTil(i);
        }

        System.out.println(lenkeliste.stoerrelse());
        

    }
}