package linked_list

import (
	"reflect"
	"testing"
)

func TestSingly(t *testing.T) {
	sll := NewSinglyLL()
	sll.AddBeg(2)
	sll.AddBeg(1)

	t.Run("Test SLL Cnt", func(t *testing.T) {
		want := 2
		got := sll.Count()
		if want != got {
			t.Errorf("got: %v, want: %v", got, want)
		}
	})

	t.Run("Test SLL Add Begin", func(t *testing.T) {
		want := []int{1, 2}
		got := []int{}
		point := sll.Head
		got = append(got, point.Val)
		for point.Next != nil {
			point = point.Next
			got = append(got, point.Val)
		}
		if !reflect.DeepEqual(got, want) {
			t.Errorf("got: %v, want: %v", got, want)
		}
	})

	sll.AddEnd(3)
	t.Run("Test SLL Add End", func(t *testing.T) {
		want := []int{1, 2, 3}
		got := []int{}
		point := sll.Head
		got = append(got, point.Val)
		for point.Next != nil {
			point = point.Next
			got = append(got, point.Val)
		}
		if !reflect.DeepEqual(got, want) {
			t.Errorf("got: %v, want: %v", got, want)
		}
	})

	t.Run("Test SLL Del Begin", func(t *testing.T) {
		want := 2
		got := sll.DeleteBeg()
		if want != got {
			t.Errorf("got: %d, want: %d", got, want)
		}

		if sll.Count() != 2 {
			t.Errorf("wrong length")
		}
	})

	t.Run("Test SLL Del End", func(t *testing.T) {
		want := 3
		got := sll.DeleteEnd()
		if want != got {
			t.Errorf("got: %d, want: %d", got, want)
		}

		if sll.Count() != 1 {
			t.Errorf("wrong length: %d", sll.Count())
		}
	})

	t.Run("Test SLL Del Empty", func(t *testing.T) {
		sll := NewSinglyLL()
		want := -1
		got := sll.DeleteBeg()
		if got != want {
			t.Errorf("got: %v, want: %v", got, want)
		}
	})
}
