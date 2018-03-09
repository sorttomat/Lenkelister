class Stabel<T> extends Lenkeliste<T> {

    public void leggPaa(T x) {
        //Legger element til i slutten av listen.
        super.leggTil(x);
    }

    public T taAv() {
        //Fjerner og returnerer det siste elementet i listen.S
        return super.fjern(super.stoerrelse() - 1);
    }
}