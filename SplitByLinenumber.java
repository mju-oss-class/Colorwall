import java.io.*;

public class SplitByLinenumber {
	public static void main(String args[]) {
		try {

		String fileName = "";
		long splitLine = 1000000;
		boolean firstHeadLine = true;
		String tmpStr = "";
		String firstLineStr = "";

		if (args.length >= 1)
			fileName = args[0];
		if (args.length >= 2) {
			splitLine = Long.parseLong(args[1]);
		}
		if (args.length >= 3 && (args[2].equals("N") || args[2].equals("n"))) {
			firstHeadLine = false;
		}

		System.out.println("���� ���ϸ� : " + fileName);
		System.out.println("���ϴ� �ټ� : " + splitLine);
		System.out.println("�Ӹ��� ���� : " + firstHeadLine);

		if (args.length < 1) {
			System.out.println("���� : java SplitByLinenumber [���ϸ�] [���ϴ� �ٰ���(default:1000000)] [Y/n = ù�� �Ӹ��� ����]");
			System.out.println("���ϴ� �ٰ���(��, �ڷ��) default ���� �鸸��, ù���� �Ӹ����̸� Y(default), ù����� �ٷ� �ڷ� �����̸� n");
			System.exit(-1);
		}

		if (firstHeadLine)
			splitLine++;

		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		int n = 1;
		long i = 0;
		File wrFile = new File(fileName+"_"+n+".txt");
		FileWriter fw = new FileWriter(wrFile);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		while ((tmpStr=br.readLine()) != null) {
			if (i == 0)
				firstLineStr = tmpStr;
			pw.println(tmpStr);
			i++;
			if (i >= splitLine) {
				pw.close();
				pw = null;
				bw.close();
				bw = null;
				fw.close();
				fw = null;
				wrFile = null;
				n++;
				wrFile = new File(fileName+"_"+n+".txt");
				fw = new FileWriter(wrFile);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
				i = 0;
				if (firstHeadLine) {
					pw.println(firstLineStr);
					i++;
				}
			}
		}
		pw.close();
		pw = null;
		bw.close();
		bw = null;
		fw.close();
		fw = null;
		wrFile = null;

		br.close();
		fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}