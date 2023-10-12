package SK;

public class MainTest {
    public static void main(String[] args) {
        Node btc = new Node("Bandung Trade Center");
        Node kings = new Node("Kings Shopping Center");
        Node ip = new Node("Istana Plaza");
        Node ciwalk = new Node("Cihampelas Walk");
        Node pvj = new Node("Paris Van Java");
        Node tsm = new Node("Trans Studio Mall");
        Node fcl = new Node("Festival City Link");
        Node bip = new Node("Bandung Indah Plaza");
        Node paskal = new Node("23 Paskal Mall");

        btc.addTetangga(kings);
        btc.addTetangga(ip);

        kings.addTetangga(btc);
        kings.addTetangga(ciwalk);
        kings.addTetangga(pvj);

        ip.addTetangga(btc);
        ip.addTetangga(pvj);
        ip.addTetangga(bip);

        ciwalk.addTetangga(kings);
        ciwalk.addTetangga(tsm);

        pvj.addTetangga(kings);
        pvj.addTetangga(ip);
        pvj.addTetangga(fcl);

        tsm.addTetangga(ciwalk);
        tsm.addTetangga(kings);

        fcl.addTetangga(pvj);
        fcl.addTetangga(bip);
        fcl.addTetangga(paskal);

        bip.addTetangga(ip);
        bip.addTetangga(fcl);

        paskal.addTetangga(fcl);
        
        System.out.println("| BFS |");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(ciwalk, fcl);
        System.out.println();
    }
}
