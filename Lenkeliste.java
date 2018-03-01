class Lenkeliste<T> implements Liste<T> {
    class Node {
        Node next;
        T data;
        public Node(T d) {
            next = null;
            data = d;
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
            System.out.println(p.data);
            p = p.next;
        }
    }

    public boolean erTom() {
        if(this.stoerrelse == 0) {
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
        ny.next = start;
        start = ny;
        oekStoerrelse();
    }

    public void leggTilSlutt(T x) {
        Node ny = new Node(x);
        Node p = start;
        while(p.next != null) {
            p = p.next;
        }
        p.next = ny;
        oekStoerrelse();
    }

    public void leggTilMidten(int pos, T x) {
        Node ny = new Node(x);
        Node p = start;

        for(int i = 1; i < pos; i ++) {
            p = p.next;
        }
        Node forskyv = p.next;
        p.next = ny;
        ny.next = forskyv;
        oekStoerrelse();
    }

    @Override
    public int stoerrelse() {
        return stoerrelse;
    }

    @Override
    public void leggTil(int pos, T x) {
        Node ny = new Node(x);

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
        Node ny = new Node(x);
        Node p = start;
        if(this.erTom()) {
            leggTilHvisTom(x);
        }
        else {
            leggTilSlutt(x);
        }

    }

    @Override
    public void sett(int pos, T x) {
        if(pos >= this.stoerrelse() || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }
        else {
            Node p = start;
            for (int i = 0; i < pos; i++) {
                p = p.next;
            }
            p.data = x;    
        }
    }

    @Override
    public T hent(int pos) {
        if(pos >= this.stoerrelse() || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }
        else {
            Node p = start;
            for (int i = 0; i < pos; i++) {
                p = p.next;
            }
            return p.data;    
        }
    }

    @Override
    public T fjern(int pos) {
        if(pos >= this.stoerrelse() || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }
        else {
            Node p = start;
            this.minskStoerrelse();
            if(pos == 0) {
                Node neste = p.next;
                start = neste;
                return p.data;
            }
            for(int i = 1; i < pos; i++) {
                p = p.next;
            }
            Node slett = p.next;
            p.next = slett.next;
            return slett.data;  
        }
    }

    @Override
    public T fjern(){
        if(this.stoerrelse() == 0) {
            throw new UgyldigListeIndeks(-1);
        }
        else {
            Node p = start;
            Node neste = p.next;
            start = neste;
            this.minskStoerrelse();
            return p.data;   
        }
    }

}