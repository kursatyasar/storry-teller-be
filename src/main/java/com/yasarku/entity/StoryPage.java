package com.yasarku.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "story_pages")
public class StoryPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer pageNumber;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(name = "image_description", length = 1000)
    private String imageDescription;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id", nullable = false)
    private Story story;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "storyPage", cascade = CascadeType.ALL, orphanRemoval = true)
    private Image image;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "storyPage", cascade = CascadeType.ALL, orphanRemoval = true)
    private Voice voice;

    // Helper methods
    public void setImage(Image image) {
        this.image = image;
        if (image != null) {
            image.setStoryPage(this);
        }
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
        if (voice != null) {
            voice.setStoryPage(this);
        }
    }
}
