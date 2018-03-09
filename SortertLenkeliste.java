class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

    @Override
    public void leggTil(T x) {
        Node ny = new Node(x);
        if(super.erTom()) {
            super.leggTilHvisTom(x);
        }
        else if(super.start.getData().compareTo(x) > 0) {
            super.leggTilStart(x);
        }
        else {
            Node p = super.start;
            for(int i = 1; i < super.stoerrelse(); i ++) {
                if(p.getNext().getData().compareTo(x) >= 0) { 
                    Node forskyv = p.getNext();
                    p.setNext(ny);
                    ny.setNext(forskyv);
                    super.oekStoerrelse();
                    return;
                }
                p = p.getNext();
            }
            super.leggTilSlutt(x);
        }
    }

    @Override
    public T fjern() {
        return super.fjern(super.stoerrelse()-1);
    }

    @Override
    public void sett(int pos, T x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggTil(int pos, T x) {
        throw new UnsupportedOperationException();
    } 
}   