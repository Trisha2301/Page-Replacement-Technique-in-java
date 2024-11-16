package SecondPkg;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class pageReplacementTechniques {
	public static void fifo(int pages[],int frames){
		int pageFault=0;
		int frameCount=0;
		int frame[] = new int[frames];
		Arrays.fill(frame, -1);
		for(int pageNumber : pages) {
			if(Arrays.stream(frame).noneMatch(value->value==pageNumber)) {
				frame[frameCount]=pageNumber;
				frameCount = (frameCount + 1) % frames;
				pageFault++;
			}
		}
		System.out.println(pageFault);
	}
	  public static void lru(int[] pages, int frames) {
	        int pageFault = 0;
	        List<Integer> frame = new ArrayList<>(); 
	        Map<Integer, Integer> recentUsage = new HashMap<>(); 
	        for (int currentIndex = 0; currentIndex < pages.length; currentIndex++) {
	            int pageNumber = pages[currentIndex];
	            if (!frame.contains(pageNumber)) {
	                if (frame.size() == frames) {
	                    int lruPage = frame.stream()
	                            .min(Comparator.comparingInt(recentUsage::get))
	                            .orElse(-1); 
	                    frame.remove(Integer.valueOf(lruPage)); 	          
	                    }
	                frame.add(pageNumber); 
	                pageFault++; 
	            }
	            recentUsage.put(pageNumber, currentIndex);
	        }

	        System.out.println("Total Page Faults (LRU): " + pageFault);
	}
 public static void optimal(int pages[], int frames) {
    int pageFault = 0;
    int frameCount = 0;
    int frame[] = new int[frames];
    Arrays.fill(frame, -1);
    for (int currentIndex = 0; currentIndex < pages.length; currentIndex++) {
        int pageNumber = pages[currentIndex];
        if (Arrays.stream(frame).noneMatch(value -> value == pageNumber)) {
            if (Arrays.stream(frame).filter(val -> val != -1).count() == frames) {
                int[] pagesIndex = new int[frames];
                for (int i = 0; i < frame.length; i++) {
                    int currentFramePage = frame[i];
                    int index = -1;
                    for (int j = currentIndex + 1; j < pages.length; j++) {
                        if (pages[j] == currentFramePage) {
                            index = j;
                            break;
                        }
                    }
                    pagesIndex[i] = (index == -1) ? Integer.MAX_VALUE : index;
                }
                int maxIndex = 0;
                for (int i = 1; i < pagesIndex.length; i++) {
                    if (pagesIndex[i] > pagesIndex[maxIndex]) {
                        maxIndex = i;
                    }
                }
                frameCount = maxIndex;
            } else 
                frameCount = (frameCount + 1) % frames;
            frame[frameCount] = pageNumber;
            ++pageFault;
        }
    }
    System.out.println(pageFault);
}
}
public class pageReplacement {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int choice=1;
		System.out.print("Enter Pages Size: ");
		int n=s.nextInt();
		int [] pages = new int [n];
		System.out.print("Enter Pages Numbers: ");
		for(int i=0;i<n;i++)
			pages[i]=s.nextInt();
		System.out.print("Enter Frames: ");
		int frames=s.nextInt();
		while(choice!=4) {
			System.out.print("Enter :\n1:FIFO\n2:LRU\n3:Optimal\n4:Exit");
			choice=s.nextInt();
			switch(choice) {
			case 1:
				pageReplacementTechniques.fifo(pages,frames);
				break;
			case 2:
				pageReplacementTechniques.lru(pages,frames);
				break;
			case 3:
				pageReplacementTechniques.optimal(pages,frames);
				break;
			case 4:
				System.out.print("Exit...");
				break;
			default:
				System.out.print("Invalid Choice");
				break;
				
				
			}
		}
	}

}

