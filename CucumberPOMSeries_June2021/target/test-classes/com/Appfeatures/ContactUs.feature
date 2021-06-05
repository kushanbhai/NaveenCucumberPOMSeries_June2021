Feature: Contact Us Feature

Scenario Outline: Contact Us scenario with different set of data
Given user navigates to contact us page
When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on send button
Then it shows successful message "Your message has been successfully sent to our team."

Examples:
|SheetName|RowNumber|
|contactUs|0|
|contactUs|1|
|contactUs|2|
|contactUs|3|
|contactUs|4|
|contactUs|5|

