class Lenkeliste<T> implements Liste<T> {
    class Node {
        private Node next;
        private T data;

        public Node(T d) {
            next = null;
            data = d;
        }

        public Node getNext() {
            return next;
        }
        public T getData() {
            return data;
        }

        public void setNext(Node ny) {
            this.next = ny;
        }

        public void setData(T nyData) {
            this.data = nyData;
        }
    }

    protected Node start = null;
    protected int stoerrelse = 0;

    public void oekStoerrelse() {
        stoerrelse++;
    }

    public void minskStoerrelse() {
        stoerrelse--;
    }

    public void print() {
        Node p = start;
        while(p != null) {
            System.out.println(p.getData());
            p = p.getNext();
        }
    }

    public boolean erTom() {
        if(stoerrelse() == 0) {
            return true;
        }
        return false;
    }

    public void leggTilHvisTom(T x) {
        Node ny = new Node(x);
        start = ny;
        oekStoerrelse();
    }

    public void leggTilStart(T x) {
        Node ny = new Node(x);
        ny.setNext(start); 
        start = ny;
        oekStoerrelse();
    }

    public void leggTilSlutt(T x) {
        Node ny = new Node(x);
        Node p = start;
        while(p.getNext() != null) {
            p = p.getNext();
        }
        p.setNext(ny);
        oekStoerrelse();
    }

    public void leggTilMidten(int pos, T x) {
        Node ny = new Node(x);
        Node p = start;

        for(int i = 1; i < pos; i ++) {
            p = p.getNext();
        }
        Node forskyv = p.getNext();
        p.setNext(ny);
        ny.setNext(forskyv);
        oekStoerrelse();
    }

    @Override
    public int stoerrelse() {
        return stoerrelse;
    }

    @Override
    public void leggTil(int pos, T x) {
        if(pos == 0) {
            leggTilStart(x);
        }
        else if((erTom() && pos != 0) || (pos > stoerrelse()) || (pos < 0)) {
            throw new UgyldigListeIndeks(pos);
        }

        else if(pos == stoerrelse()) {
            leggTilSlutt(x);
        }

        else {
            leggTilMidten(pos, x);
        }   
    }

    @Override
    public void leggTil(T x) {
        if(erTom()) {
            leggTilHvisTom(x);
        }
        else {
            leggTilSlutt(x);
        }

    }

    @Override
    public void sett(int pos, T x) {
        if(pos >= stoerrelse() || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }
        else {
            Node p = start;
            for (int i = 0; i < pos; i++) {
                p = p.getNext();
            }
            p.setData(x);
        }
    }

    @Override
    public T hent(int pos) {
        if(pos >= stoerrelse() || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }
        else {
            Node p = start;
            for (int i = 0; i < pos; i++) {
                p = p.getNext();
            }
            return p.getData();    
        }
    }

    @Override
    public T fjern(int pos) {
        if(pos >= stoerrelse() || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }
        else {
            Node p = start;
            minskStoerrelse();
            if(pos == 0) {
                Node neste = p.getNext();
                start = neste;
                return p.getData();
            }
            for(int i = 1; i < pos; i++) {
                p = p.getNext();
            }
            Node slett = p.getNext();
            p.setNext(slett.getNext());
            return slett.getData();  
        }
    }

    @Override
    public T fjern(){
        if(stoerrelse() == 0) {
            throw new UgyldigListeIndeks(-1);
        }
        else {
            Node p = start;
            Node neste = p.getNext();
            start = neste;
            minskStoerrelse();
            return p.getData();   
        }
    }

}