package excu01_java1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class excu011 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Board board = new Board();

		board.setscan(scan);

		board.start();

		scan.close();
	}
}

class Board {
	int articlesLastIndex;

	Article[] articles = new Article[100];
	Scanner scan;
	Article article = new Article();
	
		Board() {	
			articlesLastIndex = 0;
		}
		
		int getArticlesCount() {
			return articlesLastIndex + 1;
		}
// 명령어 리스트 불러오기 
		void showHelp() {
			System.out.println("== 명령어 리스트 ==");
			System.out.println("help : 명령어 리스트");
			System.out.println("list : 게시물 리스팅");
			System.out.println("add : 게시물 추가");
			System.out.println("exit : 종료");
			System.out.println("detail ${게시물 번호} : 게시물 상세보기");
		    System.out.println("remove: 게시물 삭제");
		    System.out.println("revise : 게시물 수정");
		}
// 게시물 삭제함수
		void doCommandRemove(int removeNumber) {
			for (int i = removeNumber; i < articlesLastIndex; i++) {
				articles[i] = articles[i + 1];
			}
				articlesLastIndex--;
				System.out.printf("%d번 게시물삭제가 완료되었습니다.\n",removeNumber);

	}
// 게시물 상세보기 함수
		void doCommandDetail(int Dnumber) {
			System.out.println("== 게시물 상세 ==");
			Article article = new Article();
			
			if (Dnumber > articlesLastIndex + 1) {
				System.out.println("해당 게시물은 존재하지않습니다.");
			} else {
				articles[Dnumber].view = articles[Dnumber].view + 1;
				System.out.printf("번호 : %d\n", articles[Dnumber].number);
				System.out.printf("날짜: %s\n", articles[Dnumber].regDate);
				System.out.printf("제목 : %s\n", articles[Dnumber].title);
				System.out.printf("내용 : %s\n", articles[Dnumber].body);
				System.out.printf("조회수 : %s\n", articles[Dnumber].view);
				
			}
			
	
		}

	// 입력받은 게시물 id에 해당하는 게시물 객체 리모콘을 반환한다.
		Article getArticleById(int number) {
	
			for (int i = 0; i <= articlesLastIndex; i++) {
				if (articles[i].number == number) {
					return articles[i];
				}
			}
	
			return null;
	}
// 게시물 수정함수 
		void doCommandRevise(int reviseNumber) {
			System.out.printf("%d번 게시물을 수정합니다 \n", reviseNumber);
			System.out.print("수정 할 제목: ");
			articles[reviseNumber].title = scan.next();
			System.out.print("수정 할 내용: ");
			articles[reviseNumber].body = scan.next();
			System.out.printf("수정이 완료되었습니다.\n");
		}
// 게시판 시작함수
		void start() {
			showHelp();
	
			while (true) {
				System.out.printf("명령어  => ");
				String cmd = scan.next().trim();
	
				if (cmd.equals("exit")) { // 프로그램 종료 명령어
					System.out.println("프로그램을 종료합니다.\n");
					break;
				} else if (cmd.equals("add")) { //게시물 작성 명령어
					scan.nextLine();
					doCommandAdd();
				} else if (cmd.equals("help")) {// 도움말 명령여
					scan.nextLine();
					showHelp();
				} else if (cmd.equals("list")) {// 게시판 불러오기 명령어
					scan.nextLine();
					
					doCommandList();
				} else if (cmd.equals("detail")) { // 게시물 상세보기 명령어
					scan.nextLine();
					System.out.print("조회할 게시물 번호를 입력하세요 :");
					int detailNumber = scan.nextInt();
					doCommandDetail(detailNumber);
	
				} else if (cmd.equals("remove")) {// 게시물 삭제 명령여
					scan.nextLine();
					System.out.print("삭제할 게시물 번호를 입력하세요 :");
					int removeNumber = scan.nextInt();
					doCommandRemove(removeNumber);
				} else if (cmd.equals("revise")) { // 게시물 수정 명령어
					scan.nextLine();
					System.out.print("수정이 필요한 게시물 번호를 입력하세요.");
					int reviseNumber = scan.nextInt();
	
					doCommandRevise(reviseNumber);
				}
	
				else {
					System.out.println("일치하는 명령어가 없습니다.\n");
				}
	
			}
		}
// 게시물 작성 함수
		private void doCommandAdd() {
			Article article = new Article();
			Board board = new Board();
	
			Article lastArticle = null;
			if (articlesLastIndex >= 0) {
				lastArticle = articles[articlesLastIndex];
			}
			int newNum;
			if (lastArticle == null) {
				newNum = 1;
			} 
	    else {
				newNum = lastArticle.number + 1;
			}
	
			article.number = newNum;
			article.regDate = getNowDateStr();
			System.out.printf("제목 : ");
			article.title = scan.nextLine();
			System.out.printf("내용 : ");
			article.body = scan.nextLine();
			int articlesNewInex = articlesLastIndex + 1;
			System.out.printf("%d번째 글이 생성되었습니다.\n", article.number);
			articlesLastIndex++;
			articles[articlesNewInex] = article;
	
		}
// 게시물 불러오기 함수 
		void doCommandList() {
			Article article = new Article();
			System.out.printf("== 게시물 리스트 ==\n");
			System.out.printf("번호 | 날짜                 | 제목  |조회수 \n");
			for (int i = 1; i <= articlesLastIndex; i++) {
	
				if (articles[articlesLastIndex].number == 0) {
					System.out.printf("%d번 게시물이 존재하지 않습니다.\n", articles[i].number);
				}
	
				else if (articles[articlesLastIndex].number > 0) {
	
					System.out.printf("%d    %s   %s   %d\n", articles[i].number, articles[i].regDate, articles[i].title,articles[i].view);
				}
			}
		}

		Article getLastArticle() {
			if (getArticlesCount() > 0) {
				return articles[articlesLastIndex];
			}
	
			return null;
		}

		void getDateStr() {
			getNowDateStr();
		}
// 날짜불러오기 함수
		String getNowDateStr() {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = Date.format(cal.getTime());
			return dateStr;
		}

		void setscan(Scanner scan) {
			this.scan = scan;
		}

}

class Article {
	int number;
	int view;
	String regDate;
	String title;
	String body;
}

class Menber {
	
	String name;
	int age;
	String id;
	String pw;
}
