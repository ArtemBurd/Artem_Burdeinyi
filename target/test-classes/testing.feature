Feature: File manipulation testing

@Upload
  Scenario Outline: Upload file
    Given User must upload file on dropbox with path <fileName>
    When User uploads file <fileName>
    Then User can receive info about file <fileName>
    Examples:
      |fileName|
      |"i_am_not_virus.txt"|

@GetMetadata
  Scenario Outline: Get File Metadata
    Given File <fileName> is uploaded on dropbox
    When User gets metadata of file <fileName>
    Then User can see file metadata of file <fileName>
    Examples:
      |fileName|
      |"i_am_not_virus.txt"|

 @Delete
 Scenario Outline: Delete file
   Given File <fileName> is uploaded on dropbox
   When User deletes file <fileName>
   Then File is successfully deleted
   Examples:
     |fileName|
     |"i_am_not_virus.txt"|