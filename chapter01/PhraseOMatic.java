public class PhraseOMatic{
	public static void main(String[] args){
		String[] wordListOne = {"24/7","multi-Tier","30000 foot",
								"B-to-B","win-win","front-end",
								"web-based","pervasive","smart",
								"six-sigma","critical-path","dynamic"};
		String[] wordListTwo = {"empowered","sticky","value-added",
								"orientend","centric","distributed",
								"clustered","branded","outside-the-box",
								"positioned","networked","focused",
								"leveraged","aligned","targeted",
								"shared","cooperative","accelerated"};

		String[] wordListThree = {"process","tipping-point","solution",
								"architecture","core competency","strategy",
								"mindshare","portal","space","vision",
								"paradigm","mission"};

		// 计算每一组有多少个名次术语
		int oneLength = wordListOne.length;
		int twoLength = wordListTwo.length;
		int threeLength = wordListThree.length;

		// 输出字符串的长度
		System.out.println("length1="+oneLength);
		System.out.println("length2="+twoLength);
		System.out.println("length3="+threeLength);

		// 产生随机数字
		int rand1 = (int) (Math.random() * oneLength);
		int rand2 = (int) (Math.random() * twoLength);
		int rand3 = (int) (Math.random() * threeLength);

		// 输出随机数的值
		System.out.println("rand1="+rand1);
		System.out.println("rand2="+rand2);
		System.out.println("rand1="+rand3);

		// 组合出专家术语
		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] +
			" " + wordListThree[rand3];

		// 输出
		System.out.println("What we need is a " + phrase);
	} 
}
