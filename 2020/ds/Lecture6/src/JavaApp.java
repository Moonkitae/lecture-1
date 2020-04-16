import java.io.*;
//	����Ʈ���� ��带 ����
class Node<E extends Comparable<E>> {
	private E item;
	private Node<E> left, right;
	//	������
	public Node(E newItem, Node<E> l, Node<E> r) {
		item = newItem;
		left = l;
		right = r;
	}
	public E get() { return item; }
	public void set(E newItem) { item = newItem; }
	public Node<E> getLeft() { return left; }
	public Node<E> getRight() { return right; }
	public void setLeft(Node<E> l) { left = l; }
	public void setRight(Node<E> r) { right = r; }
}
//	����Ʈ�� Ŭ����
class BinaryTree<E extends Comparable<E>> {
	private Node<E> root;
	//	������
	public BinaryTree() { root = null; }
	public Node<E> getRoot() { return root; }
	//	��ȸ
	public void PreTrav() { PreTrav(root); }
	public void PreTrav(Node<E> r) {
		if(r == null) return;
		//	������ȸ�� ��쿡�� ���� ����� ���� ���� ����Ѵ�.
		System.out.println(r.get());
		//	���� �ڽ��� �湮��� �Ѵ�.
		PreTrav(r.getLeft());
		//	������ �ڽ��� �湮��� �Ѵ�.
		PreTrav(r.getRight());
	}
	public void InTrav() { InTrav(root); }
	public void InTrav(Node<E> r) {
		if(r == null) return;
		//	���� �ڽ��� �湮��� �Ѵ�.
		InTrav(r.getLeft());
		//	������ȸ�� ��쿡�� ���� ����� ���� �����ڽ� �湮�� ����Ѵ�.
		System.out.println(r.get());
		//	������ �ڽ��� �湮��� �Ѵ�.
		InTrav(r.getRight());
	}
	public void PostTrav() { PostTrav(root); }
	public void PostTrav(Node<E> r) {
		if(r == null) return;
		//	���� �ڽ��� �湮��� �Ѵ�.
		PostTrav(r.getLeft());
		//	������ �ڽ��� �湮��� �Ѵ�.
		PostTrav(r.getRight());
		//	������ȸ�� ��쿡�� ���� ����� ���� ����ڽ� �湮�� ����Ѵ�.
		System.out.println(r.get());
	}
	//	ã��
	public E Find(E item) {
		return Find(root, item);
	}
	public E Find(Node<E> r, E item) {
		//	ã�� �����Ͱ� ���� ���
		if(r == null) {
			return null;
		}
		int t = item.compareTo(r.get());
		if(t == 0) return r.get();
		if(t < 0) return Find(r.getLeft(), item);
		return Find(r.getRight(), item);
	}
	//	����
	public void Insert(E newItem) {
		root = Insert(root, newItem);
	}
	public Node<E> Insert(Node<E> r, E newItem) {
		if(r==null) {
			r = new Node<E>(newItem, null, null);
			return r;
		}
		if(newItem.compareTo(r.get()) < 0) {
			r.setLeft(Insert(r.getLeft(), newItem));
		}
		else {
			r.setRight(Insert(r.getRight(), newItem));
		}
		return r;
	}
	//	�ּڰ� ã��
	public Node<E> GetMin() {
		//	Ʈ���� ����ִ� ���, �ּڰ��� ã�� �� �����Ƿ� null ��ȯ
		if(root==null) return null;
		return GetMin(root);
	}
	public Node<E> GetMin(Node<E> r) {
		if(r.getLeft() == null) return r;
		return GetMin(r.getLeft());
	}
	//	�ּڰ� �����ϱ�
	public void RemoveMin() {
		//	Ʈ���� ����ִ� ���, �ּڰ��� ã�� �� �����Ƿ� null ��ȯ
		if(root==null) return;
		root = RemoveMin(root);
	}
	public Node<E> RemoveMin(Node<E> r) {
		if(r.getLeft() == null) return r.getRight();
		r.setLeft(RemoveMin(r.getLeft()));
		return r;
	}
	//	��������
	public void Remove(E item) {
		root = Remove(root, item);
	}
	public Node<E> Remove(Node<E> r, E item) {
		//	item�� ���� ���� ã�� �� �� ���.
		if(r==null) return null;
		//	item�� ���ؼ�, ������ ������, ��ȸ�� ������ �����Ѵ�.
		int t = item.compareTo(r.get());
		//	���� ��쿣 ����
		if(t==0) {
			//	case 0 : �ڽ��� �ϳ��� ���� ���
			if(r.getLeft()==null && r.getRight()==null) return null;
			//	case 1 : �ڽ��� �ϳ� �ִ� ���
			if(r.getLeft()==null) return r.getRight();
			if(r.getRight()==null) return r.getLeft();
			//	case 2 : �ڽ��� �ΰ��� ���
			Node<E> min = GetMin(r.getRight());
			min.setRight(RemoveMin(r.getRight()));
			return min;
		}
		if(t < 0) {
			r.setLeft(Remove(r.getLeft(), item));;
			return r;
		}
		else {
			r.setRight(Remove(r.getRight(), item));;
			return r;
		}
	}
	//	Ʈ���� �ִ� ����� ����
	public int Size() { return Size(root); }
	public int Size(Node<E> r) {
		if(r==null) return 0;
		return Size(r.getLeft())+Size(r.getRight())+1;
	}
}
public class JavaApp {

	public static void main(String[] args) throws Exception {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.print("Enter command : ");
			String cmd = br.readLine();
			if(cmd.contains("quit")) break;
			if(cmd.contains("insert")) {
				System.out.print("Enter item to input : ");
				String param = br.readLine();
				tree.Insert(Integer.parseInt(param));
			}
			else if(cmd.contains("find")) {
				System.out.print("Enter item to find : ");
				String param = br.readLine();
				Integer res = tree.Find(Integer.parseInt(param));
				if(res==null) System.out.println("Not found");
				else System.out.println("Found");
			}
			else if(cmd.contains("remove")) {
				System.out.print("Enter item to remove : ");
				String param = br.readLine();
				tree.Remove(Integer.parseInt(param));
			}
			tree.InTrav();
		}
	}

}
