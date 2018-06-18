// This class represents a single sequence.
public class Sequence {
    private String header;
    private String seq;
    private SequenceSet ss;
    
	// Constructor.
	public Sequence(String header, String seq){
		this.header = header;
		this.seq = seq;
	}
	// Return the header of the sequence.
	public String getHeader(){
		return header;
	}
	public String getSeq(){
		return seq;
	}
	// Return the usage for word length k and window step size w.
	public Usage getUsage(int k, int w){
		return ss.getUsage(k, w);		
	}
}
