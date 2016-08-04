import java.util.*;

public class Play {

	public static void main(String[] args) {
		poker p = new poker();
		Scanner console = new Scanner(System.in);
		
		System.out.println("---------------创建扑克牌---------------");
		System.out.println("---------------扑克牌创建成功！---------------");
		System.out.print("为：【");
		for (int i = 0; i < p.po.size()-1; i++) {
			System.out.print(p.po.get(i) + ", ");
		}
		System.out.println(p.po.get(p.po.size()-1) + "】");
		
		//洗牌
		System.out.println("---------------开始洗牌---------------");
		Collections.shuffle(p.po);
		System.out.println("---------------洗牌结束---------------");
		
//		System.out.print("为：【");
//		for (int i = 0; i < p.po.size()-1; i++) {
//			System.out.print(p.po.get(i) + ", ");
//		}
//		System.out.println(p.po.get(p.po.size()-1) + "】");
		
		//创建玩家
		System.out.println("---------------创建玩家。。。----------");
		System.out.println("请输入第1位玩家的ID和姓名：");
		System.out.println("输入ID：");
		int firstId = console.nextInt();
		System.out.println("输入姓名:");
		String firstName = console.next();
		Player firstPlayer = new Player(firstId,firstName);
		
		System.out.println("请输入第2位玩家的ID和姓名：");
		System.out.println("输入ID：");
		int secondId = console.nextInt();
		System.out.println("输入姓名:");
		String secondName = console.next();
		Player secondPlayer = new Player(secondId,secondName);
		
		System.out.println("----欢迎玩家：" + firstPlayer.name);
		System.out.println("----欢迎玩家：" + secondPlayer.name);
		
		//发牌
		System.out.println("---------------开始发牌。。。----------");
		System.out.println("----玩家：" + firstPlayer.name + "拿牌");
		firstPlayer.addPoker(p.po.get(0));
		System.out.println("----玩家：" + secondPlayer.name + "拿牌");
		secondPlayer.addPoker(p.po.get(1));
		System.out.println("----玩家：" + firstPlayer.name + "拿牌");
		firstPlayer.addPoker(p.po.get(2));
		System.out.println("----玩家：" + secondPlayer.name + "拿牌");
		secondPlayer.addPoker(p.po.get(3));
		System.out.println("---------------发牌结束！--------------");
		
		//游戏
		System.out.println("---------------开始游戏。。。----------");
		System.out.println("玩家：" + firstPlayer.name + "最大的手牌为：" +
				maxPoker(firstPlayer.hasPoker));
		System.out.println("玩家：" + secondPlayer.name + "最大的手牌为：" +
				maxPoker(secondPlayer.hasPoker));
		
		String winName = win(firstPlayer, secondPlayer);
		System.out.println("---------------玩家：" + winName + 
				"获胜！--------");
		
		System.out.println("玩家各自的手牌为：");
		System.out.println(firstPlayer.name + "：【" + firstPlayer.hasPoker.get(0) + "," +
				firstPlayer.hasPoker.get(1) + "】");
		System.out.println(secondPlayer.name + "：【" + secondPlayer.hasPoker.get(0) + "," +
				secondPlayer.hasPoker.get(1) + "】");
	}

	private static String maxPoker(List<String> Poker) {
		int num1 = 0;
		if (Poker.get(0).length() > 3) num1 = 10;
		else if (Poker.get(0).charAt(2) >= '0' && Poker.get(0).charAt(2) <= '9') 
			num1 = Integer.parseInt(Poker.get(0).charAt(2)+"");
		else if (Poker.get(0).charAt(2) == 'J') num1 = 11;
		else if (Poker.get(0).charAt(2) == 'Q') num1 = 12;
		else if (Poker.get(0).charAt(2) == 'K') num1 = 13;
		else if (Poker.get(0).charAt(2) == 'A') num1 = 14;
		
		int num2 = 0;
		if (Poker.get(1).length() > 3) num2 = 10;
		else if (Poker.get(1).charAt(2) >= '0' && Poker.get(1).charAt(2) <= '9') 
			num2 = Integer.parseInt(Poker.get(1).charAt(2)+"");
		else if (Poker.get(1).charAt(2) == 'J') num2 = 11;
		else if (Poker.get(1).charAt(2) == 'Q') num2 = 12;
		else if (Poker.get(1).charAt(2) == 'K') num2 = 13;
		else if (Poker.get(1).charAt(2) == 'A') num2 = 14;
		
		//System.out.println(Poker.get(1).charAt(0));
		
		if (num1 > num2) return Poker.get(0);
		else if (num1 < num2) return Poker.get(1);
		else {
			int num11 = 0;
			int num22 = 0;
			if (Poker.get(0).charAt(0) == '方') num11 = 1;
			else if (Poker.get(0).charAt(0) == '梅') num11 = 2;
			else if (Poker.get(0).charAt(0) == '红') num11 = 3;
			else num11 = 4;
			
			if (Poker.get(1).charAt(0) == '方') num22 = 1;
			else if (Poker.get(1).charAt(0) == '梅') num22 = 2;
			else if (Poker.get(1).charAt(0) == '红') num22 = 3;
			else num22 = 4;
			
			if (num11 < num22) return Poker.get(1);
			else return Poker.get(0);
		}
	}

	private static String win(Player first, Player second) {
		String f = maxPoker(first.hasPoker);
		String s = maxPoker(second.hasPoker);
		List<String> list = new ArrayList<String>();
		list.add(f);
		list.add(s);
		String result = maxPoker(list);
		if (result.equals(f)) return first.name;
		return second.name;
	}

}










