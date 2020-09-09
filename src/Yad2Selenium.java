public class Yad2Selenium {

    public static void main(String[] args){
        System.out.println("\n\n*********Test has been started*********\n\n");
        PageManager pageManager = new PageManager();
        pageManager.init();
        try {
            pageManager.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("*********Test has been ended successfully!*********\n\n");
        pageManager.end();
    }
}
