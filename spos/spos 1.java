package java_23;

public class spos1 {
	public static void main(String[] args) {
		int i;
		String a[][]= {
				{"","START","101",""},
				{"","MOVER","BREG","ONE"},
				{"AGAIN","MULT","BREG","TERM"},
				{"","MOVER","CREG","TERM"},
				{"","ADD","CREG","N"},
				{"","MOVEM","CREG","TERM"},
				{"N","DS","2",""},
				{"RESULT","DS","2",""},
				{"ONE","DC","1",""},
				{"TERM","DS","1",""},
				{"","END","",""}};
		int lc = Integer.parseInt(a[0][2]);
		String st[][]=new String[5][2];
		int cnt = 0;
		for(i=1;i<11;i++) {
			if(a[i][0]!="") {
				st[cnt][0]=a[i][0];
				st[cnt][1]= Integer.toString(lc);
				cnt++;
				if(a[i][1]=="DS") {
					int d= Integer.parseInt(a[i][2]);
					lc = lc+d;}
				else {
					lc++;}
			}
			else {
				lc++;}}
		System.out.println("symbol table");
		for(i=0;i<5;i++) {
			for(cnt=0;cnt<2;cnt++) {
				System.out.println(st[i][cnt]+"\t");}
			System.out.println();
				}
			}
		}
	
