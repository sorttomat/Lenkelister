class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {
    
    public Node finnSiste() {
        Node p = super.start;
        while(p.next != null) {
            p = p.next;
        }
        return p.next;
    }

    @Override
    public void leggTil(T x) {
        Node ny = new Node(x);
        if(super.erTom()) {
            super.leggTilHvisTom(x);
        }
        else if(super.start.data.compareTo(x) > 0) {
            super.leggTilStart(x);
        }
        else {
            Node p = super.start;
            for(int i = 1; i < super.stoerrelse(); i ++) {
                if(p.next.data.compareTo(x) >= 0) { 
                    Node forskyv = p.next;
                    p.next = ny;
                    ny.next = forskyv;
                    super.oekStoerrelse();
                    return;
                }
                p = p.next;
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