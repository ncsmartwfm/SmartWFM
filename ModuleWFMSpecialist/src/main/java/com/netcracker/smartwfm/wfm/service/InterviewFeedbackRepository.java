package com.netcracker.smartwfm.wfm.service;

import com.netcracker.smartwfm.wfm.dao.InterviewFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewFeedbackRepository extends JpaRepository<InterviewFeedback, String> {
    InterviewFeedback findByInterviewId(String interviewId);
}
