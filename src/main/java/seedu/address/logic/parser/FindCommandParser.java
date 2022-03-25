package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.TagContainsKeywordsPredicate;
import seedu.address.model.task.NameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        String[] allKeywords = trimmedArgs.split("\\s+");

        List<String> nameKeywords = Arrays.asList(allKeywords);

        Set<String> tagKeywords = new HashSet<>();
        for (String keyword : allKeywords) {
            if (keyword.startsWith(PREFIX_TAG.toString())) {
                String keywordWithoutPrefix = keyword.replace(PREFIX_TAG.toString(), "");
                if (!keywordWithoutPrefix.equals("")) {
                    tagKeywords.add(keywordWithoutPrefix);
                }
            }
        }

        return new FindCommand(new NameContainsKeywordsPredicate(nameKeywords),
                new TagContainsKeywordsPredicate(tagKeywords));
    }

}
