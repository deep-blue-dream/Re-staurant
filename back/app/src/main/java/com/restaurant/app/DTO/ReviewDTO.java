package com.restaurant.app.DTO;

import com.restaurant.app.model.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long reviewIndex;
    private String email;
    private String reviewTitle;
    private String reviewContent;

    private String reviewImage;

    private String nickName;

    private int tag;

    private int revisit;

    public ReviewDTO(Review review) {
        this.reviewIndex = review.getReviewIndex();
        this.email = review.getUser().getEmail();
        this.reviewTitle = review.getReviewTitle();
        this.reviewContent = review.getReviewContent();
        this.nickName = review.getUser().getNickname();
        this.reviewImage = review.getReviewImage();
        this.revisit = review.getRevisit();
        this.tag = review.getTag();
    }



}