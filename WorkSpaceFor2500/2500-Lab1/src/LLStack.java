
public class LLStack<T>
{
	protected LLNode<T> top;
	
	public LLStack()
	{
		top = null;
	}
	
	public boolean isEmpty()
	{
		return (top == null);
	}
	
	public void push(T element)
	{
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
	}
	
	public void pop() throws StackUnderflowException
	{
		if (isEmpty())
		{
			throw new StackUnderflowException("Attempt to pop empty stack");
		}
		else
		{
			top = top.getLink();
		}
	}
	
	public T top() throws StackUnderflowException
	{
		if (isEmpty())
		{
			throw new StackUnderflowException("Attempt top() on empty stack");
		}
		else
		{
			return top.getInfo();
		}
	}
}
