<div class="contentItem">

  <div class="contentItemLinks">
    <a href="./help/staticPages.html" target="_blank">Help</a>
  </div>

  <h1>Unpublished blog entries</h1>
  <h2>&nbsp;</h2>

  <div class="contentItemBody">
    <form name="unpublishedBlogEntriesForm" method="post" action="manageBlogEntries.secureaction">
      <input type="hidden" name="redirectUrl" value="${blog.url}viewUnpublishedBlogEntries.secureaction" />
    <table width="99%" cellspacing="0" cellpadding="4">
      <thead>
      <tr>
        <th><input type="checkbox" name="allEntries" onclick="toggleCheckAll(document.unpublishedBlogEntriesForm.allEntries, document.unpublishedBlogEntriesForm.entry)"/></th>
        <th>Title</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="blogEntry" items="${unpublishedBlogEntries}" varStatus="status">
        <c:choose>
          <c:when test="${status.count % 2 == 0}">
            <tr class="even small">
          </c:when>
          <c:otherwise>
              <tr class="odd small">
          </c:otherwise>
        </c:choose>
        <td width="2%">
          <input type="checkbox" name="entry" value="${blogEntry.id}" />
        </td>
        <td>
          <a href="editBlogEntry.secureaction?entry=${blogEntry.id}#form">${blogEntry.title}</a>
        </td>
      </tr>
      </c:forEach>
      </tbody>
    </table>

    <br />

    <table width="99%" cellspacing="0" cellpadding="0">
      <tr>
        <td align="right">
          <input name="submit" type="submit" value="Publish" />
          <input name="submit" type="submit" value="Remove" />
        </td>
      </tr>
    </table>
    </form>
  </div>

</div>