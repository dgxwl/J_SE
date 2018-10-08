package designpattern.behavioral.memento.blackbox;

class Originator {
    private int state;
    
    public Originator() {
	}
 
    public Originator(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

    public void setState(int state) {
        this.state = state;
    }
    
	public Memento createMemento() {
        return new Memento(state);
    }
 
    public void restoreFromMemento(Memento memento) {
        this.state = memento.getState();
    }

    public static class Memento {
        private final int state;

        public Memento(int state) {  //对外开放
            this.state = state;
        }

        private int getState() {  //仅对外部类开放
			return state;
		}
    }
}
