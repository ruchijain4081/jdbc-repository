package COM.RAYS.MARKSEET;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testGet();
		//testSearch();
		//testUpdate() ;
		//testDelete();
		 meritList();
		

	}

	private static void testSearch() throws Exception {

		MarksheetModel model = new MarksheetModel();

		ArrayList<MarksheetBean> list = model.search();

		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {
			MarksheetBean bean = (MarksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" + bean.getFname());
			System.out.print("\t" + bean.getLname());
			System.out.print("\t" + bean.getPhy());
			System.out.print("\t" + bean.getChem());
			System.out.println("\t" + bean.getMath());
		}

	}

	private static void testGet() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.get("121");

		System.out.print(bean.getId());
		System.out.print("\t" + bean.getRollno());
		System.out.print("\t" + bean.getFname());
		System.out.print("\t" + bean.getLname());
		System.out.print("\t" + bean.getPhy());
		System.out.print("\t" + bean.getChem());
		System.out.println("\t" + bean.getMath());

	}

	public static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setRollno("a123");
		bean.setFname("ruchi");
		bean.setLname("jain");
		bean.setPhy(89);
		bean.setChem(60);
		bean.setMath(90);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setFname("ram");
		bean.setLname("madhav");
		bean.setId(5);
		System.out.println("data updated");
		MarksheetModel model = new MarksheetModel();
		model.Update(bean);
	}

	public static void testDelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno("a123");
		System.out.println("data has been deleted");
		MarksheetModel model = new MarksheetModel();
		model.Delete(bean);
	}
	private static void meritList() throws Exception {

		MarksheetModel model = new MarksheetModel();

		ArrayList<MarksheetBean> list = model.getMeritList();

		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {
			MarksheetBean bean = (MarksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" + bean.getFname());
			System.out.print("\t" + bean.getLname());
			System.out.print("\t" + bean.getPhy());
			System.out.print("\t" + bean.getChem());
			System.out.println("\t" + bean.getMath());
			
			 
			
			
		}

	}
	
}
