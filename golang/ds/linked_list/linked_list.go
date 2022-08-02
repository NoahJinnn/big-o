package linked_list

type Node struct {
	Next *Node
	Val  int
}

func NewNode(val int) *Node {
	return &Node{
		Next: nil,
		Val:  val,
	}
}

type SinglyLL struct {
	Head *Node
}

func NewSinglyLL() *SinglyLL {
	return &SinglyLL{}
}

func (ll *SinglyLL) AddBeg(val int) {
	n := NewNode(val)
	n.Next = ll.Head
	ll.Head = n
}

func (ll *SinglyLL) AddEnd(val int) {
	n := NewNode(val)
	point := ll.Head
	for {
		if point.Next == nil {
			break
		}
		point = point.Next
	}

	point.Next = n
}

func (ll *SinglyLL) DeleteBeg() int {
	if ll.Head == nil {
		return -1
	}
	ll.Head = ll.Head.Next
	return ll.Head.Val
}

func (ll *SinglyLL) DeleteEnd() int {
	if ll.Head == nil {
		return -1
	}
	point := ll.Head
	var delete int
	for {
		if point.Next.Next == nil {
			delete = point.Next.Val
			point.Next = nil
			break
		}
		point = point.Next
	}
	return delete
}

func (ll *SinglyLL) Reverse() {
	var prev, next *Node
	cur := ll.Head
	for cur != nil {
		next = cur.Next
		cur.Next = prev
		prev = cur
		cur = next
	}
}

func (ll *SinglyLL) Count() int {
	cnt := 0
	if ll.Head == nil {
		return cnt
	}
	point := ll.Head
	for point.Next != nil {
		cnt++
		point = point.Next
	}
	return cnt + 1
}
