package com.app.neurorehab.domain.model.DataTypes;

import org.springframework.util.StringUtils;

/**
 * Types of user contribution.
 */
public enum ContributionType {

    RESEARCH,
    CONCEPT,
    TESTCASE,
    DEVELOPER;

    public static ContributionType getContribution(final String value) {

        ContributionType contributionTypeDefault = ContributionType.RESEARCH;
        for (final ContributionType contributionType : ContributionType.values()) {

            if (contributionType.toString().equals(value)) {
                contributionTypeDefault = contributionType;
            }
        }

        return contributionTypeDefault;
    }

    public static String stringifyContributionType(final ContributionType contributionType){

        if(contributionType.equals(ContributionType.TESTCASE)){
            return "Test Case";
        }else{
            return contributionType.toString().toLowerCase();
        }
    }
}
