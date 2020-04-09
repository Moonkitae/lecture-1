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
	//	Ʈ���� �ִ� ����� ����
	public int Size() { return Size(root); }
	public int Size(Node<E> r) {
		if(r==null) return 0;
		return Size(r.getLeft())+Size(r.getRight())+1;
	}
}
public class JavaApp {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.Insert(5);
		tree.Insert(2);
		tree.Insert(4);
		System.out.println("size = "+tree.Size());
		System.out.println("Preorder");
		tree.PreTrav();
		System.out.println("Inorder");
		tree.InTrav();
		System.out.println("Postorder");
		tree.PostTrav();
		tree.Insert(8);
		System.out.println("size = "+tree.Size());
		System.out.println("Preorder");
		tree.PreTrav();
		System.out.println("Inorder");
		tree.InTrav();
		System.out.println("Postorder");
		tree.PostTrav();
	}

}
