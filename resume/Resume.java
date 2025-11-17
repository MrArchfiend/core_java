package resume;
public class Resume<T extends JobRole> {
    private T role;
    public Resume(T role) { this.role = role; }
}
