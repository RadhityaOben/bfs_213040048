package SK;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch {

    public void search(Node start, Node goal) {
        Queue<Solusi> queue = new LinkedBlockingQueue<>();
        Solusi solusiStart = new Solusi();
        solusiStart.setNode(start);
        queue.add(solusiStart);
        System.out.println("Mencari Jalur dari |"+start.getNilai()+"| => |"+goal.getNilai() + "|");
        System.out.println();

        int suks = 0;
        int ev = 0;
        int no = 1;
        System.out.println("Perjalanan Dimulai");
        System.out.println("==============================");
        
        while (!queue.isEmpty()) {

            if(ev == suks) {
                suks = 0;
                ev = 0;
            }
            Solusi eval = queue.poll();
            System.out.println(no++ + ". " + eval.getNode().getNilai());
            
            if (eval.getNode().equals(goal)) {
                System.out.println("\nJalur ditemukan: ");
                for(Node node: eval.getNodes()) {
                    System.out.print(node.getNilai()+" -> ");
                }
                System.out.println(eval.getNode().getNilai());
                break;
            } else {
                for (Node successor: eval.getNode().getTetangga()) {
                    System.out.print(successor.getNilai()+" | ");
                    Solusi solusiSuksesor = new Solusi();
                    solusiSuksesor.setNode(successor);
                    solusiSuksesor.setNodes(eval.getNodes());
                    solusiSuksesor.getNodes().add(eval.getNode());
                    
                    queue.offer(solusiSuksesor);
                    if(ev == 0) {
                        suks++;
                    }
                }
                System.out.println();
                System.out.println();
                System.out.println();
                if(ev == 0) {
                    System.out.println("==============================");
                    no = 1;
                }
                ev++;
            }
        }

    }
}
