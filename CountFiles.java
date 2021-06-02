import java.io.File;


public class CountFiles {

	static int sum = 0;
	static int total = 0;

	public static void main(String[] args) {

		System.out.println("Path is : " + args[0]);
		System.out.println("File Type : " + args[1]);
		System.out.println("=====================================================");
		File f = new File(args[0]);

		if (f.exists() && f.isDirectory()) {
			File arr[] = f.listFiles();

			RecursivePrint(arr, 0, 0, args[1]);
			
			System.out.println();
			System.out.println("Total Files : "+total);

		}
	}

	static void RecursivePrint(File[] arr, int index, int level, String type) {
		int count = 0;

		// terminate condition
		if (index == arr.length) {
			if (sum != 0) {
				System.out.println(type + "_count : " + sum);
				System.out.println("--------------------------------------");
				total = total+sum;
			}
			return;
		}
		// tabs for internal levels
		// for (int i = 0; i < level; i++)
		// System.out.print("-");

		// for files
		if (arr[index].isFile()) {

			if (arr[index].getName().contains(type))
			// System.out.println(arr[index].getName());
			{
				count++;
				sum = sum + count;

			}
		}

		// for sub-directories
		else if (arr[index].isDirectory()) {
			System.out.print(arr[index].getName() + "|");

			// recursion for sub-directories
			RecursivePrint(arr[index].listFiles(), 0, level + 1, type);
			sum = 0;
		}

		// recursion for main directory
		RecursivePrint(arr, ++index, level, type);

	}

}
