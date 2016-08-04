import java.util.*;

public class poker {
	public List<String> po;
	public String kind;
	public String num;
	
	public poker() {
		po = new ArrayList<String>();
		String pai;
		for (int i = 0; i < 4; i++) {
			if (i == 0) kind = "方片";
			else if (i == 1) kind = "梅花";
			else if (i == 2) kind = "红桃";
			else kind = "黑桃";
			for (int j = 2; j < 15; j++) {
				if (j == 11) num = "J";
				else if (j == 12) num = "Q";
				else if (j == 13) num = "K";
				else if (j == 14) num = "A";
				else num = j + "";
				pai = kind+num;
				po.add(pai);
			}
		}
	}
}
