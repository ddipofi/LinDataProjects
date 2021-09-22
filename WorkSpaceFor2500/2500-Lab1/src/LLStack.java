

public class LLStack<T>
{
	LLNode head;
	
	private class LLNode<T> {
		T value;
		LLNode next;
		
		LLNode(T value) {
			this.value = value;
		}
		void setNext(LLNode node) {
			this.next = node;
		}
		T getValue() {
			return value;
		}
	}
}
