package dev.enterprise.model;


public class QandA {
    // Primary Key
    private int id;
    // Not Null
    private String question;
    private String answer;
    private ReferenceLink referenceLink;
    private Participant responsible;
    // Not Null
    private Topic topic;


    public QandA(int id, String question, String answer, ReferenceLink referenceLink, Participant responsible, Topic topic) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.referenceLink = referenceLink;
        this.responsible = responsible;
        this.topic = topic;
    }
    public QandA(String question,Topic topic) {
        this.question = question;
        this.topic=topic;
    }

    public QandA() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ReferenceLink getReferenceLink() {
        return referenceLink;
    }

    public void setReferenceLink(ReferenceLink referenceLink) {
        this.referenceLink = referenceLink;
    }

    public Participant getResponsible() {
        return responsible;
    }

    public void setResponsible(Participant responsible) {
        this.responsible = responsible;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "QandA{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", referenceLink=" + referenceLink +
                ", responsible=" + responsible +
                ", topic=" + topic +
                '}';
    }
}
