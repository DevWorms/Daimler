//
// Copyright 2016 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.7
//
package com.developers.devworms.daimler_android.mobile;

import com.amazonaws.regions.Regions;

/**
 * This class defines constants for the developer's resource
 * identifiers and API keys. It should be kept private.
 */
public class AWSConfiguration {

    // AWS MobileHub user agent string
    public static final String AWS_MOBILEHUB_USER_AGENT =
        "MobileHub b8289fb4-9b14-4064-b49f-e7899d8f4562 aws-my-sample-app-android-v0.7";
    // AMAZON COGNITO
    public static final Regions AMAZON_COGNITO_REGION =
        Regions.US_EAST_1;
    public static final String  AMAZON_COGNITO_IDENTITY_POOL_ID =
        "us-east-1:8ca17b44-da8e-4680-be6f-ce6741243334";
    // GOOGLE CLOUD MESSAGING API KEY
    public static final String GOOGLE_CLOUD_MESSAGING_API_KEY =
        "AIzaSyCOw48yiCKkE4br1nytc96Q2EhZSd-RLl4";
    // GOOGLE CLOUD MESSAGING SENDER ID
    public static final String GOOGLE_CLOUD_MESSAGING_SENDER_ID =
        "61280670776";

    // SNS PLATFORM APPLICATION ARN
    public static final String AMAZON_SNS_PLATFORM_APPLICATION_ARN =
        "arn:aws:sns:us-east-1:534003673918:app/GCM/daimler_MOBILEHUB_1142686579";
    // SNS DEFAULT TOPIC ARN
    public static final String AMAZON_SNS_DEFAULT_TOPIC_ARN =
        "arn:aws:sns:us-east-1:534003673918:daimler_alldevices_MOBILEHUB_1142686579";
    // SNS PLATFORM TOPIC ARNS
    public static final String[] AMAZON_SNS_TOPIC_ARNS =
        {"arn:aws:sns:us-east-1:534003673918:cmp_alldevices_MOBILEHUB_432977209"};
}
